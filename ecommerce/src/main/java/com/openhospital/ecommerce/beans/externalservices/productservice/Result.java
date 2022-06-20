package com.openhospital.ecommerce.beans.externalservices.productservice;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Result {

    private Boolean validResponse;
    private String code;
    private String description;

}
