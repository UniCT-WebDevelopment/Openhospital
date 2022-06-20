package com.openhospital.productservice.beans.wards;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@ApiModel(description = "getWards call let you receive our ward list")
@ToString
public class GetWardsInput {

  @JsonProperty("lang")
  private String lang = null;


   /**
   * Response language
   * @return lang
  **/
  @ApiModelProperty(required = true, value = "Response language")
  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }
  
}

