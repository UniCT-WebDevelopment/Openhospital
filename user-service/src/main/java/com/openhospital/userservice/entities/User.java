package com.openhospital.userservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "SURNAME", nullable = false, length = 50)
    private String surname;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = 512)
    private String password;

    @Column(name = "TAX_CODE", nullable = false, length = 16)
    private String taxCode;

    @Column(name = "COUNTRY", nullable = false, length = 50)
    private String country;

    @Column(name = "CITY", nullable = false, length = 50)
    private String city;

    @Column(name = "PROVINCE", nullable = false, length = 50)
    private String province;

    @Column(name = "POST_CODE", nullable = false, length = 5)
    private String postCode;

    @Column(name = "ADDRESS", nullable = false, length = 100)
    private String address;

    @Column(name = "ADDRESS_NUMBER", nullable = false, length = 10)
    private String addressNumber;

    @Column(name = "PHONE", nullable = false, length = 20)
    private String phone;

    @Column(name = "CONSENT_1", nullable = false)
    private Boolean consent1 = false;

    @Column(name = "CONSENT_2", nullable = false)
    private Boolean consent2 = false;

    @Column(name = "CONSENT_3", nullable = false)
    private Boolean consent3 = false;

    @Column(name = "INSERT_TIMESTAMP", nullable = false)
    private Instant insertTimestamp;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

    @Column(name = "USER_TYPE", nullable = false, length = 10)
    private String userType;

    @Column(name = "ENABLED", nullable = false)
    private Boolean enabled = false;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public Boolean getConsent3() {
        return consent3;
    }

    public void setConsent3(Boolean consent3) {
        this.consent3 = consent3;
    }

    public Boolean getConsent2() {
        return consent2;
    }

    public void setConsent2(Boolean consent2) {
        this.consent2 = consent2;
    }

    public Boolean getConsent1() {
        return consent1;
    }

    public void setConsent1(Boolean consent1) {
        this.consent1 = consent1;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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