package com.openhospital.ecommerce.beans.externalservices.productservice.proposal.get;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class GetProposalsInput {

    private String productType;
    private String wardCode;
    private String doctor;
    private String lang;
    private String checkIn;
  
}