package com.openhospital.productservice.beans.proposals.lock;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.Objects;

/**
 * InputProposal
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-11T17:32:31.984+02:00")
@ToString
public class InputProposal {
  @JsonProperty("proposalId")
  private long proposalId = 0;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("surname")
  private String surname = null;

  @JsonProperty("email")
  private String email = null;

  public InputProposal proposalId(long proposalId) {
    this.proposalId = proposalId;
    return this;
  }

  /**
   * ID della proposal per la quale si richiede la prenotazione
   * @return proposalId
   **/
  @ApiModelProperty(required = true, value = "ID della proposal per la quale si richiede la prenotazione")
  public long getProposalId() {
    return proposalId;
  }

  public void setProposalId(long proposalId) {
    this.proposalId = proposalId;
  }

  public InputProposal name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Nome utente intestatario del ticket
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Nome utente intestatario del ticket")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InputProposal surname(String surname) {
    this.surname = surname;
    return this;
  }

   /**
   * Cognome utente intestatario del ticket
   * @return surname
  **/
  @ApiModelProperty(required = true, value = "Cognome utente intestatario del ticket")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public InputProposal email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email utente intestatario del ticket
   * @return email
   **/
  @ApiModelProperty(required = true, value = "Email utente intestatario del ticket")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputProposal lockProposalsInputProposal = (InputProposal) o;
    return Objects.equals(this.proposalId, lockProposalsInputProposal.proposalId) &&
        Objects.equals(this.name, lockProposalsInputProposal.name) &&
        Objects.equals(this.surname, lockProposalsInputProposal.surname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(proposalId, name, surname);
  }

  public String toStringVerbose() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputProposal {\n");
    
    sb.append("    sequenceNumber: ").append(toIndentedString(proposalId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
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

