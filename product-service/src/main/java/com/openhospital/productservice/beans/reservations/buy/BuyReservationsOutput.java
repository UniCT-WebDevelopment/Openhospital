package com.openhospital.productservice.beans.reservations.buy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openhospital.productservice.beans.GenericOutput;
import com.openhospital.productservice.beans.Result;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Struttura dati output per metodo lockProposals
 */
@ApiModel(description = "Struttura dati output per metodo lockProposals")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-11T17:32:31.984+02:00")
@ToString
public class BuyReservationsOutput extends GenericOutput {

  public BuyReservationsOutput result(Result result) {
    this.result = result;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuyReservationsOutput lockProposalsOutput = (BuyReservationsOutput) o;
    return Objects.equals(this.result, lockProposalsOutput.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  public String toStringVerbose() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuyReservationsOutput {\n");
    
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

