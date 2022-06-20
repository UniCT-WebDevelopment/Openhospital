package com.openhospital.productservice.beans.reservations.buy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.Objects;

/**
 * InputReservation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-11T17:32:31.984+02:00")
@ToString
public class InputReservation {
  @JsonProperty("reservationId")
  private long reservationId = 0;

  public InputReservation reservationId(long reservationId) {
    this.reservationId = reservationId;
    return this;
  }

  /**
   * ID della reservation per la quale si richiede la prenotazione
   * @return reservationId
   **/
  @ApiModelProperty(required = true, value = "ID della reservation per la quale si richiede la prenotazione")
  public long getReservationId() {
    return reservationId;
  }

  public void setReservationId(long reservationId) {
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
    InputReservation lockProposalsInputProposal = (InputReservation) o;
    return Objects.equals(this.reservationId, lockProposalsInputProposal.reservationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reservationId);
  }

  public String toStringVerbose() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputReservation {\n");
    
    sb.append("    sequenceNumber: ").append(toIndentedString(reservationId)).append("\n");
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

