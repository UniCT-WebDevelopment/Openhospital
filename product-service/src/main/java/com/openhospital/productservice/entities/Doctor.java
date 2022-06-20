package com.openhospital.productservice.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "DOCTOR", indexes = {
        @Index(name = "CONSTRAINT_INDEX_78", columnList = "WARD_CODE")
})
public class Doctor {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "SURNAME", nullable = false, length = 50)
    private String surname;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "MOBILE_PHONE", nullable = false, length = 20)
    private String mobilePhone;

    @Column(name = "OFFICE_PHONE", nullable = false, length = 20)
    private String officePhone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "WARD_CODE", nullable = false, referencedColumnName = "WARD_CODE")
    private Ward wardCode;

    @Column(name = "INSERT_TIMESTAMP", nullable = false)
    private Instant insertTimestamp;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

    @Column(name = "ENABLED", nullable = false)
    private Boolean enabled = false;

    @OneToMany(mappedBy = "doctor")
    private Set<MedicalService> medicalServices = new LinkedHashSet<>();

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

    public Ward getWardCode() {
        return wardCode;
    }

    public void setWardCode(Ward wardCode) {
        this.wardCode = wardCode;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}