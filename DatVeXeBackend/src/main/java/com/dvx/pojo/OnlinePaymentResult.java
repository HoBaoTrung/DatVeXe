/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvx.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "online_payment_result")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OnlinePaymentResult.findAll", query = "SELECT o FROM OnlinePaymentResult o"),
    @NamedQuery(name = "OnlinePaymentResult.findByPaymentId", query = "SELECT o FROM OnlinePaymentResult o WHERE o.paymentId = :paymentId"),
    @NamedQuery(name = "OnlinePaymentResult.findByPaymentCode", query = "SELECT o FROM OnlinePaymentResult o WHERE o.paymentCode = :paymentCode"),
    @NamedQuery(name = "OnlinePaymentResult.findByCreatedAt", query = "SELECT o FROM OnlinePaymentResult o WHERE o.createdAt = :createdAt")})
public class OnlinePaymentResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_id")
    private Long paymentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "payment_code")
    private String paymentCode;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentId")
    @JsonIgnore
    private Set<Order> order1Set;

    public OnlinePaymentResult() {
    }

    public OnlinePaymentResult(Long paymentId) {
        this.paymentId = paymentId;
    }

    public OnlinePaymentResult(Long paymentId, String paymentCode) {
        this.paymentId = paymentId;
        this.paymentCode = paymentCode;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @XmlTransient
    public Set<Order> getOrder1Set() {
        return order1Set;
    }

    public void setOrder1Set(Set<Order> order1Set) {
        this.order1Set = order1Set;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OnlinePaymentResult)) {
            return false;
        }
        OnlinePaymentResult other = (OnlinePaymentResult) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dvx.pojo.OnlinePaymentResult[ paymentId=" + paymentId + " ]";
    }
    
}
