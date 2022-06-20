package com.openhospital.ecommerce.entities;

import com.openhospital.ecommerce.constants.OrderStatus;
import com.openhospital.ecommerce.utils.DateUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "PURCHASE")
public class Purchase {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "PNR", length = 10)
    private String pnr;

    @Column(name = "ETICKET_ID")
    private Integer eticketId;

    @Column(name = "FATT_ID")
    private Integer fattId;

    @Column(name = "NOTE", length = 2000)
    private String note;

    @Column(name = "PAYMENT_METHOD", nullable = false, length = 20)
    private String paymentMethod;

    @Column(name = "STATUS", nullable = false, length = 2)
    private String status;

    @Column(name = "INSERT_TIMESTAMP", nullable = false)
    private Instant insertTimestamp;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

    @OneToMany(mappedBy = "purchase")
    private Set<Product> products = new LinkedHashSet<>();

    @OneToMany(mappedBy = "purchase")
    private Set<Userdata> userdata = new LinkedHashSet<>();

    public Set<Userdata> getUserdata() {
        return userdata;
    }

    public void setUserdata(Set<Userdata> userdata) {
        this.userdata = userdata;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Instant getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Instant updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public Instant getInsertTimestamp() {
        return insertTimestamp;
    }

    public void setInsertTimestamp(Instant insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getFattId() {
        return fattId;
    }

    public void setFattId(Integer fattId) {
        this.fattId = fattId;
    }

    public Integer getEticketId() {
        return eticketId;
    }

    public void setEticketId(Integer eticketId) {
        this.eticketId = eticketId;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}