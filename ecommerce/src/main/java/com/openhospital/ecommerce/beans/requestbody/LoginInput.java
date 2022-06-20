package com.openhospital.ecommerce.beans.requestbody;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class LoginInput {

    private String email;
    private String password;
  
}