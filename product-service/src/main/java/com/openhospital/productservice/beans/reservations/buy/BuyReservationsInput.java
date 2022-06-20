package com.openhospital.productservice.beans.reservations.buy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Struttura dati input per metodo lockProposals
 */
@ApiModel(description = "Struttura dati input per metodo lockProposals")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-11T17:32:31.984+02:00")
@ToString
public class BuyReservationsInput {

  @JsonProperty("reservations")
  private List<InputReservation> reservations = new ArrayList<InputReservation>();

  public BuyReservationsInput reservations(List<InputReservation> reservations) {
    this.reservations = reservations;
    return this;
  }

  public BuyReservationsInput addReservationsItem(InputReservation reservationsItem) {
    this.reservations.add(reservationsItem);
    return this;
  }

   /**
   * Array contenente l’elenco delle proposal presenti nell’ordine di cui si richiede venga effettuato il processo di lock
   * @return proposals
  **/
  @ApiModelProperty(required = true, value = "Array contenente l’elenco delle proposal presenti nell’ordine di cui si richiede venga effettuato il processo di lock")
  public List<InputReservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<InputReservation> reservations) {
    this.reservations = reservations;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuyReservationsInput lockProposalsInput = (BuyReservationsInput) o;
    return Objects.equals(this.reservations, lockProposalsInput.reservations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reservations);
  }

  public String toStringVerbose() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuyReservationsInput {\n");

    sb.append("    proposals: ").append(toIndentedString(reservations)).append("\n");
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

