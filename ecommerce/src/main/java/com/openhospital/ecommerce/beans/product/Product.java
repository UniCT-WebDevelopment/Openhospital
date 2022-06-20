package com.openhospital.ecommerce.beans.product;

import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;

@Data
@Log4j2
@ToString
public class Product {

    private BigDecimal proposalId = null;
    private String productCode;
    private String productDescription;
    private String productInformation;
    private BigDecimal price = null;
    private BigDecimal availablePlaces = null;
    private BigDecimal maxQuantity = null;

}
