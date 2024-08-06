/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findById", query = "SELECT c FROM Car c WHERE c.id = :id"),
    @NamedQuery(name = "Car.findByCarNumber", query = "SELECT c FROM Car c WHERE c.carNumber = :carNumber")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "car_number")
    private String carNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carId")
    @JsonIgnore
    private Set<Seat> seatSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carId")
    @JsonIgnore
    private Set<Trip> tripSet;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Types typeId;
    @Column(name = "seat_price")
    private Double seatPrice;

    public Car() {
    }

    public Car(Long id) {
        this.id = id;
    }

    public Car(Long id, String carNumber) {
        this.id = id;
        this.carNumber = carNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @XmlTransient
    public Set<Seat> getSeatSet() {
        return seatSet;
    }

    public void setSeatSet(Set<Seat> seatSet) {
        this.seatSet = seatSet;
    }

    @XmlTransient
    public Set<Trip> getTripSet() {
        return tripSet;
    }

    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
    }

    public Types getTypeId() {
        return typeId;
    }

    public void setTypeId(Types typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dvx.pojo.Car[ id=" + id + " ]";
    }

    /**
     * @return the seatPrice
     */
    public Double getSeatPrice() {
        return seatPrice;
    }

    /**
     * @param seatPrice the seatPrice to set
     */
    public void setSeatPrice(Double seatPrice) {
        this.seatPrice = seatPrice;
    }
    
}
