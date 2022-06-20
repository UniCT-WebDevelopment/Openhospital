package com.openhospital.productservice.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "WARD", indexes = {
        @Index(name = "CONSTRAINT_INDEX_2", columnList = "WARD_CODE", unique = true)
})
public class Ward {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "WARD_CODE", nullable = false, length = 50)
    private String wardCode;

    @Column(name = "INSERT_TIMESTAMP", nullable = false)
    private Instant insertTimestamp;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

    @Column(name = "ENABLED", nullable = false)
    private Boolean enabled = false;

    @OneToMany(mappedBy = "wardCode")
    private Set<WardDescr> wardDescrs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "wardCode")
    private Set<Health> health = new LinkedHashSet<>();

    @OneToMany(mappedBy = "wardCode")
    private Set<Doctor> doctors = new LinkedHashSet<>();

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Set<Health> getHealth() {
        return health;
    }

    public void setHealth(Set<Health> health) {
        this.health = health;
    }

    public Set<WardDescr> getWardDescrs() {
        return wardDescrs;
    }

    public void setWardDescrs(Set<WardDescr> wardDescrs) {
        this.wardDescrs = wardDescrs;
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

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}