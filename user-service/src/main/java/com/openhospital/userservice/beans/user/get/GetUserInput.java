package com.openhospital.userservice.beans.user.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@ApiModel(description = "getUser call let you receive userInfo")
@ToString
public class GetUserInput {

  @JsonProperty("email")
  private String email = null;


  /**
   * User email
   * @return email
   **/
  @ApiModelProperty(required = true, value = "User email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}

