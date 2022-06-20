package com.openhospital.ecommerce.beans.externalservices.userservice.edit;

import com.openhospital.ecommerce.beans.externalservices.userservice.Result;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EditUserOutput {
  protected Result result;
  private Integer userId;

  public EditUserOutput() {
  }

  public EditUserOutput(Result result) {
    this.result = result;
  }

  public EditUserOutput(Result result, Integer userId) {
    this.result = result;
    this.userId = userId;
  }

}