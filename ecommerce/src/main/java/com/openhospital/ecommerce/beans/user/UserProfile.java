package com.openhospital.ecommerce.beans.user;

import com.openhospital.ecommerce.beans.externalservices.userservice.get.OutputUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserProfile extends User {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String taxCode;
    private String country;
    private String city;
    private String province;
    private String postCode;
    private String address;
    private String addressNumber;
    private String phone;
    private Boolean consent1 = false;
    private Boolean consent2 = false;
    private Boolean consent3 = false;
    private Instant insertTimestamp;
    private Instant updateTimestamp;
    private String userType;
    private Boolean enabled = false;

    public UserProfile(Integer id, String name, String surname, String email, String password, String taxCode, String country, String city, String province, String postCode, String address, String addressNumber, String phone, Boolean consent1, Boolean consent2, Boolean consent3, Instant insertTimestamp, Instant updateTimestamp, String userType, Boolean enabled, List<GrantedAuthority> authorities) {

        super(email, password, enabled, true, true, true, authorities);

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.taxCode = taxCode;
        this.country = country;
        this.city = city;
        this.province = province;
        this.postCode = postCode;
        this.address = address;
        this.addressNumber = addressNumber;
        this.phone = phone;
        this.consent1 = consent1;
        this.consent2 = consent2;
        this.consent3 = consent3;
        this.userType = userType;
        this.enabled = enabled;
    }

    public UserProfile(OutputUser user, List<GrantedAuthority> authorities) {

        super(user.getEmail(), user.getPassword(), user.getEnabled(), true, true, true, authorities);

        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.taxCode = user.getTaxCode();
        this.country = user.getCountry();
        this.city = user.getCity();
        this.province = user.getProvince();
        this.postCode = user.getPostCode();
        this.address = user.getAddress();
        this.addressNumber = user.getAddressNumber();
        this.phone = user.getPhone();
        this.consent1 = user.getConsent1();
        this.consent2 = user.getConsent2();
        this.consent3 = user.getConsent3();
        this.userType = user.getUserType();
        this.enabled = user.getEnabled();
    }

    public UserProfile() {
        super("", "", null);
    }

}
