package com.openhospital.productservice.beans.proposals.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@ApiModel(description = "getProposals call let you receive our proposal")
@ToString
public class GetProposalsInput {

  @JsonProperty("productType")
  private String productType = null;

  @JsonProperty("wardCode")
  private String wardCode = null;

  @JsonProperty("doctor")
  private String doctor = null;

  @JsonProperty("lang")
  private String lang = null;

  @JsonProperty("checkIn")
  private String checkIn = null;


  /**
   * Product type:  HEALTH - DOCTOR
   * @return productType
   **/
  @ApiModelProperty(required = true, value = "Product type:  HEALTH - DOCTOR")
  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }


   /**
   * Ward code
   * @return wardCode
  **/
  @ApiModelProperty(value = "Ward code")
  public String getWardCode() {
    return wardCode;
  }

  public void setWardCode(String wardCode) {
    this.wardCode = wardCode;
  }


   /**
   * Doctor name
   * @return doctorName
  **/
  @ApiModelProperty(required = false, value = "Doctor name")
  public String getDoctor() {
    return doctor;
  }

  public void setDoctor(String doctor) {
    this.doctor = doctor;
  }


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


  /**
   * Check-in date (required for HEALTH products)
   * @return checkIn
   **/
  @ApiModelProperty(required = false, value = "Check-in date")
  public String getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(String checkIn) {
    this.checkIn = checkIn;
  }
}

