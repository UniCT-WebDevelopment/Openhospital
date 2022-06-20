package com.openhospital.productservice.beans.proposals.lock;

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
public class LockProposalsInput {

  @JsonProperty("proposals")
  private List<InputProposal> proposals = new ArrayList<InputProposal>();

  public LockProposalsInput proposals(List<InputProposal> proposals) {
    this.proposals = proposals;
    return this;
  }

  public LockProposalsInput addProposalsItem(InputProposal proposalsItem) {
    this.proposals.add(proposalsItem);
    return this;
  }

   /**
   * Array contenente l’elenco delle proposal presenti nell’ordine di cui si richiede venga effettuato il processo di lock
   * @return proposals
  **/
  @ApiModelProperty(required = true, value = "Array contenente l’elenco delle proposal presenti nell’ordine di cui si richiede venga effettuato il processo di lock")
  public List<InputProposal> getProposals() {
    return proposals;
  }

  public void setProposals(List<InputProposal> proposals) {
    this.proposals = proposals;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LockProposalsInput lockProposalsInput = (LockProposalsInput) o;
    return Objects.equals(this.proposals, lockProposalsInput.proposals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(proposals);
  }

  public String toStringVerbose() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LockProposalsInput {\n");

    sb.append("    proposals: ").append(toIndentedString(proposals)).append("\n");
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

