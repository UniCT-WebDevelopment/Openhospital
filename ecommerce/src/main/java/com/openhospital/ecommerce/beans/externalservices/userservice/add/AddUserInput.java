package com.openhospital.ecommerce.beans.externalservices.userservice.add;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class AddUserInput {

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
  private String userType;

}

