package com.openhospital.productservice.beans.wards;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * GetProposalsOutputProposals
 */
@ToString
public class WardOutput {
  @JsonProperty("wardId")
  private BigDecimal wardId = null;

  @JsonProperty("wardCode")
  private String wardCode = null;

  @JsonProperty("wardDescription")
  private String wardDescription = null;

  @JsonProperty("lang")
  private String lang = null;

  public WardOutput wardId(BigDecimal wardId) {
    this.wardId = wardId;
    return this;
  }

   /**
   * ID del reparto
   * @return wardId
  **/
  @ApiModelProperty(required = true, value = "ID del reparto")
  public BigDecimal getWardId() {
    return wardId;
  }

  public void setWardId(BigDecimal wardId) {
    this.wardId = wardId;
  }


  /**
   * Codice del reparto
   * @return wardCode
   **/
  @ApiModelProperty(required = true, value = "Codice del reparto")
  public String getWardCode() {
    return wardCode;
  }

  public void setWardCode(String wardCode) {
    this.wardCode = wardCode;
  }


  /**
   * Descrizione del reparto
   * @return wardDescription
   **/
  @ApiModelProperty(required = true, value = "Descrizione del reparto")
  public String getWardDescription() {
    return wardDescription;
  }

  public void setWardDescription(String wardDescription) {
    this.wardDescription = wardDescription;
  }


  /**
   * Lingua
   * @return lang
  **/
  @ApiModelProperty(required = true, value = "Lingua")
  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

}

