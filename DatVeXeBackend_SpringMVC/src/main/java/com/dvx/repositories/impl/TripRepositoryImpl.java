/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.repositories.impl;

import com.dvx.dto.TripDTO;
import com.dvx.mapper.TripDTOMapper;
import com.dvx.pojo.Route;
import com.dvx.pojo.Station;
import com.dvx.pojo.Trip;
import com.dvx.repositories.TripRepository;
import com.dvx.services.StationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class TripRepositoryImpl implements TripRepository {

    @Autowired
    private TripDTOMapper tripMapper;

    @Autowired
    private Environment env;

    @Autowired
    private StationService stationService;

    @Autowired
    private LocalSessionFactoryBean Factory;

    public static String[] splitStringByComma(String input) {
        if (input == null || input.isEmpty()) {
            return null; // Trả về danh sách rỗng nếu chuỗi đầu vào là null hoặc rỗng
        }
        String[] parts = input.split("\\s*,\\s*"); // Tách chuỗi theo dấu phẩy, bỏ khoảng trắng
        return parts; // Chuyển mảng thành danh sách
    }

    @Override
    public List<Trip> findTripByRoute(Route r, Calendar d) {

        Session session = Factory.getObject().getCurrentSession();

        Query query = session.createQuery("FROM Trip  where routeId=:a and YEAR(departAt)=:y and MONTH(departAt)=:m "
                + "and DAY(departAt)=:d");
        query.setParameter("a", r);
        query.setParameter("y", d.get(Calendar.YEAR));
        query.setParameter("m", d.get(Calendar.MONTH) + 1);
        query.setParameter("d", d.get(Calendar.DATE));
        return query.getResultList();
    }

    @Override
    public List<?> getAllTrip(Map<String, String> params) {
        Session session = Factory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Trip> query = builder.createQuery(Trip.class);
        Root<Trip> rootTrip = query.from(Trip.class);
        query.orderBy(builder.desc(rootTrip.get("id")));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
// kiểm tra người dùng có phải admin hay không
        String userAdmin = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            userAdmin = authentication.getName(); // Lấy tên người dùng
        }
        boolean isAdmin = userAdmin.contains("admin");

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            //Lấy các trip theo điều kiện
            String fromProvince = params.get("fromProvince");
            String toProvince = params.get("toProvince");

            // Tạo join với bảng Route
            Join<Trip, Route> routeJoin = rootTrip.join("routeId");

            if ((fromProvince != null && !fromProvince.isEmpty())) {
                Station from = this.stationService.getStationsByID(Long.parseLong(fromProvince));
                predicates.add(builder.equal(routeJoin.get("fromStation"), from));

            }

            if ((toProvince != null && !toProvince.isEmpty())) {
                Station to = this.stationService.getStationsByID(Long.parseLong(toProvince));
                predicates.add(builder.equal(routeJoin.get("toStation"), to));
            }

            String price = params.get("price");
            if ((price != null && !price.isEmpty())) {
                String[] parts = splitStringByComma(price);// Tách chuỗi theo dấu phẩy, bỏ khoảng trắng

                predicates.add(builder.greaterThanOrEqualTo(rootTrip.get("price"), Double.parseDouble(parts[0]) * 1000));
                predicates.add(builder.lessThanOrEqualTo(rootTrip.get("price"), Double.parseDouble(parts[1]) * 1000));
            }

            String time = params.get("time");
            if ((time != null && !time.isEmpty())) {
                String[] parts = splitStringByComma(time);

                javax.persistence.criteria.Expression<Integer> tripHour = builder.function("HOUR", Integer.class, rootTrip.get("departAt"));

                predicates.add(builder.greaterThanOrEqualTo(tripHour, Integer.parseInt(parts[0])));
                predicates.add(builder.lessThanOrEqualTo(tripHour, Integer.parseInt(parts[1])));
            }

            String departureDate = params.get("departureDate");
            if ((departureDate != null && !departureDate.isEmpty())) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date departDate = null;
                try {
                    departDate = dateFormat.parse(departureDate);
                } catch (ParseException e) {
                    e.printStackTrace();  // Bắt lỗi nếu ngày không đúng định dạng
                }
                
                predicates.add(builder.equal(builder.function("date", Date.class, rootTrip.get("departAt")), departDate));
            }

            query.where(predicates.toArray(Predicate[]::new));
        }
        Query q = session.createQuery(query);

        if (isAdmin) {
            if (params != null) {
                String page = params.get("page");
                if (page != null && !page.isEmpty()) {
                    int p = Integer.parseInt(page);
                    q.setMaxResults(pageSize);
                    q.setFirstResult((p - 1) * pageSize);
                } else {
                    q.setMaxResults(pageSize);
                    q.setFirstResult(0);
                }
            }
            return q.getResultList();
        }
        return tripMapper.toOrdersResponseList(q.getResultList());

    }

    @Override
    public Long countTrip() {
        Session session = Factory.getObject().getCurrentSession();

        Query query = session.createQuery("SELECT Count(*) FROM Trip");
        return Long.parseLong(query.getSingleResult().toString());
    }

    @Override
    public Trip getTripbyID(long id) {
        Session session = Factory.getObject().getCurrentSession();
        Query query = session.createNamedQuery("Trip.findById");
        query.setParameter("id", id);
        return (Trip) query.getSingleResult();
    }

    @Override
    public boolean addOrUpdateTrip(Trip p) {
        Session s = Factory.getObject().getCurrentSession();
        try {
            if (p.getId() == null) {
                s.save(p);
            } else {
                s.update(p);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTrip(long t) {

        Session s = Factory.getObject().getCurrentSession();
        try {

            s.delete(this.getTripbyID(t));

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
