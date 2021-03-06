/*
 * PPE - Interfaccia Vendita Prodotti
 * PPE - Interfaccia Vendita Prodotti
 *
 * OpenAPI spec version: 1.0
 * Contact: mario.alberti@seamilano.eu
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.openhospital.productservice.beans.proposals.lock;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * OutputReservation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-11T17:32:31.984+02:00")
@ToString
public class OutputReservation {
  @JsonProperty("proposalId")
  private BigDecimal proposalId = null;

  @JsonProperty("reservationId")
  private BigDecimal reservationId = null;

  public OutputReservation proposalId(BigDecimal proposalId) {
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

  public OutputReservation reservationId(BigDecimal reservationId) {
    this.reservationId = reservationId;
    return this;
  }

   /**
   * ID della reservation generata dal sistema
   * @return reservationId
  **/
  @ApiModelProperty(required = true, value = "ID della reservation generata dal sistema")
  public BigDecimal getReservationId() {
    return reservationId;
  }

  public void setReservationId(BigDecimal reservationId) {
    this.reservationId = reservationId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OutputReservation lockProposalsOutputReservations = (OutputReservation) o;
    return Objects.equals(this.proposalId, lockProposalsOutputReservations.proposalId) &&
        Objects.equals(this.reservationId, lockProposalsOutputReservations.reservationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(proposalId, reservationId);
  }

  public String toStringVerbose() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OutputReservation {\n");

    sb.append("    proposalId: ").append(toIndentedString(proposalId)).append("\n");
    sb.append("    reservationId: ").append(toIndentedString(reservationId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}