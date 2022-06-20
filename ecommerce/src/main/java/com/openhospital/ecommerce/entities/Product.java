package com.openhospital.ecommerce.entities;

import com.openhospital.ecommerce.utils.DateUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "PRODUCT", indexes = {
        @Index(name = "CONSTRAINT_INDEX_18", columnList = "PURCHASE_ID")
})
public class Product {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PURCHASE_ID", nullable = false)
    private Purchase purchase;

    @Column(name = "PRODUCT_TYPE", nullable = false, length = 10)
    private String productType;

    @Column(name = "PRODUCT_CODE", nullable = false, length = 10)
    private String productCode;

    @Column(name = "PRODUCT_DESCRIPTION", nullable = false, length = 100)
    private String productDescription;

    @Column(name = "PRODUCT_INFO", length = 100)
    private String productInfo;

    @Column(name = "CHECK_IN")
    private Instant checkIn;

    @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "PROPOSAL_ID", nullable = false)
    private Integer proposalId;

    @Column(name = "RESERVATION_ID")
    private Integer reservationId;

    @Column(name = "INSERT_TIMESTAMP", nullable = false)
    private Instant insertTimestamp;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

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

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getProposalId() {
        return proposalId;
    }

    public void setProposalId(Integer proposalId) {
        this.proposalId = proposalId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Instant getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Instant checkIn) {
        this.checkIn = checkIn;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}