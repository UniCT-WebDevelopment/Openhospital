package com.openhospital.userservice.beans.user.add;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@ApiModel(description = "addUser call let you register user inside the system")
@ToString
public class AddUserInput {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("surname")
  private String surname = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("taxCode")
  private String taxCode = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("province")
  private String province = null;

  @JsonProperty("postCode")
  private String postCode = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("addressNumber")
  private String addressNumber = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("consent1")
  private Boolean consent1 = null;

  @JsonProperty("consent2")
  private Boolean consent2 = null;

  @JsonProperty("consent3")
  private Boolean consent3 = null;

  @JsonProperty("userType")
  private String userType = null;


  /**
   * User name
   * @return name
   **/
  @ApiModelProperty(required = true, value = "User name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  /**
   * User surname
   * @return surname
   **/
  @ApiModelProperty(required = true, value = "User surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }


  /**
   * User email
   * @return email
   **/
  @ApiModelProperty(required = true, value = "User email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  /**
   * User password: encrypted with BCryptPasswordEncoder
   * @return password
   **/
  @ApiModelProperty(required = true, value = "User password: encrypted with BCryptPasswordEncoder")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  /**
   * User taxCode
   * @return taxCode
   **/
  @ApiModelProperty(required = true, value = "User taxCode")
  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }


  /**
   * User country
   * @return country
   **/
  @ApiModelProperty(required = true, value = "User country")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  /**
   * User city
   * @return city
   **/
  @ApiModelProperty(required = true, value = "User city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  /**
   * User province
   * @return province
   **/
  @ApiModelProperty(required = true, value = "User province")
  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }


  /**
   * User postCode
   * @return postCode
   **/
  @ApiModelProperty(required = true, value = "User postCode")
  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }


  /**
   * User address
   * @return address
   **/
  @ApiModelProperty(required = true, value = "User address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  /**
   * User address number
   * @return addressNumber
   **/
  @ApiModelProperty(required = true, value = "User address number")
  public String getAddressNumber() {
    return addressNumber;
  }

  public void setAddressNumber(String addressNumber) {
    this.addressNumber = addressNumber;
  }


  /**
   * User phone
   * @return phone
   **/
  @ApiModelProperty(required = true, value = "User phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  /**
   * User consent 1
   * @return consent1
   **/
  @ApiModelProperty(required = true, value = "User consent 1")
  public Boolean getConsent1() {
    return consent1;
  }

  public void setConsent1(Boolean consent1) {
    this.consent1 = consent1;
  }


  /**
   * User consent 2
   * @return consent2
   **/
  @ApiModelProperty(required = true, value = "User consent 2")
  public Boolean getConsent2() {
    return consent2;
  }

  public void setConsent2(Boolean consent2) {
    this.consent2 = consent2;
  }


  /**
   * User consent 3
   * @return consent3
   **/
  @ApiModelProperty(required = true, value = "User consent 3")
  public Boolean getConsent3() {
    return consent3;
  }

  public void setConsent3(Boolean consent3) {
    this.consent3 = consent3;
  }


  /**
   * User type: USER - DOCTOR - ADMIN
   * @return userType
   **/
  @ApiModelProperty(required = true, value = "User type: USER - DOCTOR - ADMIN")
  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

}

