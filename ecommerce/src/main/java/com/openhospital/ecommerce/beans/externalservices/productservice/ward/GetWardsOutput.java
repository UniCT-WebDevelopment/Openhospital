package com.openhospital.ecommerce.beans.externalservices.productservice.ward;

import com.openhospital.ecommerce.beans.externalservices.productservice.Result;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class GetWardsOutput {
  protected Result result;
  private List<Ward> wards;

  public GetWardsOutput() {
  }

  public GetWardsOutput(Result result) {
    this.result = result;
  }

  public GetWardsOutput(Result result, List<Ward> wards) {
    this.result = result;
    this.wards = wards;
  }

}