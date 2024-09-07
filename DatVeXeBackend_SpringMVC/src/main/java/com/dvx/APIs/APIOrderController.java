/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.APIs;

import com.dvx.pojo.Orders;
import com.dvx.pojo.Seat;
import com.dvx.pojo.Ticket;
import com.dvx.pojo.Trip;
import com.dvx.services.OrderService;
import com.dvx.services.RouteService;
import com.dvx.services.SeatService;
import com.dvx.services.TicketService;
import com.dvx.services.TripService;
import com.dvx.services.TypesService;
import com.dvx.configs.VnpayConfig;
import com.dvx.services.UserService;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class APIOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private TripService tripSer;

    @Autowired
    private TicketService ticketSer;

    @Autowired
    private UserService userSer;

    @Autowired
    private VnpayConfig vnpayConfig;

    //thêm hóa đơn
    @PostMapping("/addOrder/{id}")
    public ResponseEntity<?> addOrder(@PathVariable(value = "id") long tripId, @RequestBody List<String> seatIDs,
            Principal p) {

        Orders order = new Orders();
        order.setCustomerId(userSer.getUserByEmail(p.getName()));

        orderService.addOrUpdateOrder(order);

        Trip trip = tripSer.getTripbyID(tripId);
        //Tong tien phai tra
        long amount = (long) trip.getPrice() * seatIDs.size();
        for (String seatID : seatIDs) {
            Ticket t = new Ticket();
            t.setExpiredAt(trip.getDepartAt());
            t.setIsActive(Boolean.TRUE);
            t.setOrderId(order);
            t.setTripId(trip);

            t.setSeatId(seatService.getSteatsByID(Long.parseLong(seatID)));
            ticketSer.addOrUpdateTicket(t);
        }

        return new ResponseEntity<>(createURLVnpay(amount, order.getId() + "", "vn"), HttpStatus.OK);
    }

    public String createURLVnpay(long total, String orderInfor, String locate) {

        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_TxnRef = vnpayConfig.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";
        String vnp_TmnCode = vnpayConfig.vnp_TmnCode;
        String orderType = "order-type";

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(total * 100));
        vnp_Params.put("vnp_CurrCode", "VND");

        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Payment for order " + orderInfor);
        vnp_Params.put("vnp_OrderType", orderType);

        vnp_Params.put("vnp_Locale", locate);

        // urlReturn += vnpayConfig.secretKey;
        vnp_Params.put("vnp_ReturnUrl", vnpayConfig.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                try {
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = vnpayConfig.hmacSHA512(vnpayConfig.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = vnpayConfig.vnp_PayUrl + "?" + queryUrl;
        return paymentUrl;
    }

    public static Long extractNumberFromString(String str) {
        // Sử dụng regex để tìm số trong chuỗi
        String number = str.replaceAll("[^0-9]", "");

        // Chuyển đổi chuỗi số thành kiểu Long, nếu không tìm thấy số trả về null
        if (!number.isEmpty()) {
            return Long.parseLong(number);
        } else {
            return null;  // Hoặc có thể trả về giá trị mặc định khác
        }
    }

    //kiểm tra tình trạng sau khi thanh toán
    @PostMapping("/checkPaySuccess")
    private void checkPaySuccess(@RequestParam Map<String, String> params) {
        Long orderId = extractNumberFromString(params.get("vnp_OrderInfo"));
        
        if (params.get("vnp_ResponseCode").equals("00")) {
            String vnpPayDate = params.get("vnp_PayDate");
            
            // Định dạng ban đầu của chuỗi ngày
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddHHmmss");

            try {
                // Chuyển chuỗi thành đối tượng Date
                Date date = inputFormat.parse(vnpPayDate);

                this.ticketSer.updatePaymentTicket(orderId, date);

            } catch (ParseException e) {
                e.printStackTrace(); // Xử lý lỗi nếu chuỗi không hợp lệ
            }
            
            

        } else {
            delete(orderId);
        }
    }

    @DeleteMapping("/deleteOrder/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") long id) {

        this.orderService.deleteOrder(id);
    }

}
