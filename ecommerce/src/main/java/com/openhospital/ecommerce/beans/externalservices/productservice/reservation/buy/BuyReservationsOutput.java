package com.openhospital.ecommerce.beans.externalservices.productservice.reservation.buy;

import com.openhospital.ecommerce.beans.externalservices.productservice.Result;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BuyReservationsOutput {
  protected Result result;

  public BuyReservationsOutput() {
  }

  public BuyReservationsOutput(Result result) {
    this.result = result;
  }

}