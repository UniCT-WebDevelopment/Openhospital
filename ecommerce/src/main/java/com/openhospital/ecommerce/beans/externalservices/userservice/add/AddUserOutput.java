package com.openhospital.ecommerce.beans.externalservices.userservice.add;

import com.openhospital.ecommerce.beans.externalservices.userservice.Result;
import com.openhospital.ecommerce.beans.externalservices.userservice.get.OutputUser;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddUserOutput {
  protected Result result;
  private Integer userId;

  public AddUserOutput() {
  }

  public AddUserOutput(Result result) {
    this.result = result;
  }

  public AddUserOutput(Result result, Integer userId) {
    this.result = result;
    this.userId = userId;
  }

}