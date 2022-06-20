package com.openhospital.productservice.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "HEALTH", indexes = {
        @Index(name = "CONSTRAINT_INDEX_7", columnList = "WARD_CODE")
})
public class Health {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "WARD_CODE", nullable = false, referencedColumnName = "WARD_CODE")
    private Ward wardCode;

    @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "INSERT_TIMESTAMP", nullable = false)
    private Instant insertTimestamp;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

    @Column(name = "ENABLED", nullable = false)
    private Boolean enabled = false;

    @OneToMany(mappedBy = "health")
    private Set<MedicalService> medicalServices = new LinkedHashSet<>();

    @OneToMany(mappedBy = "health")
    private Set<HealthDescr> healthDescrs = new LinkedHashSet<>();

    public Set<HealthDescr> getHealthDescrs() {
        return healthDescrs;
    }

    public void setHealthDescrs(Set<HealthDescr> healthDescrs) {
        this.healthDescrs = healthDescrs;
    }

    public Set<MedicalService> getMedicalServices() {
        return medicalServices;
    }

    public void setMedicalServices(Set<MedicalService> medicalServices) {
        this.medicalServices = medicalServices;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Ward getWardCode() {
        return wardCode;
    }

    public void setWardCode(Ward wardCode) {
        this.wardCode = wardCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}