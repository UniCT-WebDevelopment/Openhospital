package com.openhospital.ecommerce.beans.externalservices.userservice.get;

import com.openhospital.ecommerce.beans.externalservices.userservice.Result;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GetUserOutput {
  protected Result result;
  private OutputUser user;

  public GetUserOutput() {
  }

  public GetUserOutput(Result result) {
    this.result = result;
  }

  public GetUserOutput(Result result, OutputUser user) {
    this.result = result;
    this.user = user;
  }

}