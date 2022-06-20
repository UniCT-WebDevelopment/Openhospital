package com.openhospital.ecommerce.beans.requestbody;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class SearchResultsInput {

    private String productType;
    private String wardCode;
    private String doctor;
    private String lang;
    private String checkIn;
    private String checkInTime;
  
}