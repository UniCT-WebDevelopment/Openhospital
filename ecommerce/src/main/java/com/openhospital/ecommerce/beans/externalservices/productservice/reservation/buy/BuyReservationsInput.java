package com.openhospital.ecommerce.beans.externalservices.productservice.reservation.buy;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Data
@Log4j2
public class BuyReservationsInput {

    private List<InputReservation> reservations;
  
}