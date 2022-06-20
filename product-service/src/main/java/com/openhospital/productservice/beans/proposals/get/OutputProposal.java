package com.openhospital.productservice.beans.proposals.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * GetProposalsOutputProposals
 */
@ToString
public class OutputProposal {
  @JsonProperty("proposalId")
  private BigDecimal proposalId = null;

  @JsonProperty("productType")
  private String productType = null;

  @JsonProperty("productCode")
  private String productCode = null;

  @JsonProperty("productDescription")
  private String productDescription = null;

  @JsonProperty("productInformations")
  private String productInformations = null;

  @JsonProperty("wardCode")
  private String wardCode = null;

  @JsonProperty("wardDescription")
  private String wardDescription = null;

  @JsonProperty("mobilePhone")
  private String mobilePhone = null;

  @JsonProperty("officePhone")
  private String officePhone = null;

  @JsonProperty("checkIn")
  private String checkIn = null;

  @JsonProperty("price")
  private BigDecimal price = null;

  @JsonProperty("availablePlaces")
  private BigDecimal availablePlaces = null;

  @JsonProperty("maxQuantity")
  private BigDecimal maxQuantity = null;

  public OutputProposal proposalId(BigDecimal proposalId) {
    this.proposalId = proposalId;
    return this;
  }

   /**
   * ID della proposta
   * @return proposalId
  **/
  @ApiModelProperty(required = true, value = "ID della proposta")
  public BigDecimal getProposalId() {
    return proposalId;
  }

  public void setProposalId(BigDecimal proposalId) {
    this.proposalId = proposalId;
  }


   /**
   * Tipo di prodotto restituito -  HEALTH - DOCTOR
   * @return productType
  **/
  @ApiModelProperty(required = true, value = "Tipo di prodotto restituito -  HEALTH - DOCTOR")
  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }


   /**
   * Codice del prodotto restituito
   * @return productCode
  **/
  @ApiModelProperty(required = true, value = "Codice del prodotto restituito")
  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }


   /**
   * Descrizione del prodotto
   * @return productDescription
  **/
  @ApiModelProperty(required = true, value = "Descrizione del prodotto")
  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }


  /**
   * Informazioni del prodotto
   * @return productInformations
   **/
  @ApiModelProperty(required = true, value = "Informazioni del prodotto")
  public String getProductInformations() {
    return productInformations;
  }

  public void setProductInformations(String productInformations) {
    this.productInformations = productInformations;
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
   * Numero di telefono mobile
   * @return mobilePhone
   **/
  @ApiModelProperty(required = true, value = "Numero di telefono mobile")
  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  /**
   * Numero di telefono dell'ufficio
   * @return officePhone
   **/
  @ApiModelProperty(required = true, value = "Numero di telefono dell'ufficio")
  public String getOfficePhone() {
    return officePhone;
  }

  public void setOfficePhone(String officePhone) {
    this.officePhone = officePhone;
  }


  /**
   * Check-in date
   * @return checkIn
   **/
  @ApiModelProperty(value = "Check-in date")
  public String getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(String checkIn) {
    this.checkIn = checkIn;
  }


  /**
   * Prezzo del prodotto
   * @return price
  **/
  @ApiModelProperty(required = true, value = "Prezzo del prodotto")
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }


   /**
   * Numero di posti disponibili
   * @return availablePlaces
  **/
  @ApiModelProperty(required = true, value = "Numero di posti disponibili")
  public BigDecimal getAvailablePlaces() {
    return availablePlaces;
  }

  public void setAvailablePlaces(BigDecimal availablePlaces) {
    this.availablePlaces = availablePlaces;
  }


   /**
   * Quantità massima acquistabile
   * @return maxQuantity
  **/
  @ApiModelProperty(required = true, value = "Quantità massima acquistabile")
  public BigDecimal getMaxQuantity() {
    return maxQuantity;
  }

  public void setMaxQuantity(BigDecimal maxQuantity) {
    this.maxQuantity = maxQuantity;
  }
  
}

