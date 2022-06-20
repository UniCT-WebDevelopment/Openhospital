package com.openhospital.userservice.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openhospital.userservice.constants.ReturnCodes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.Objects;

/**
 * Oggetto contenente l’esito della chiamata
 */
@ApiModel(description = "Oggetto contenente l’esito della chiamata")
@ToString
public class Result {
  @JsonProperty("validResponse")
  private Boolean validResponse = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("description")
  private String description = null;

  public Result() {
  }
  
  public Result(ReturnCodes rc) {
	  this.validResponse = rc.isValidResponse();
	  this.code = rc.getCode();
	  this.description = rc.getDescription();
  }
  
  public Result validResponse(Boolean validResponse) {
    this.validResponse = validResponse;
    return this;
  }

   /**
   * Flag esplicativo della validità della risposta
   * @return validResponse
  **/
  @ApiModelProperty(required = true, value = "Flag esplicativo della validità della risposta")
  public Boolean getValidResponse() {
    return validResponse;
  }

  public void setValidResponse(Boolean validResponse) {
    this.validResponse = validResponse;
  }

  public Result code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Codice dell’esito della chiamata
   * @return code
  **/
  @ApiModelProperty(required = true, value = "Codice dell’esito della chiamata")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Result description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Descrizione dell’esito della chiamata
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Descrizione dell’esito della chiamata")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Result result = (Result) o;
    return Objects.equals(this.validResponse, result.validResponse) &&
        Objects.equals(this.code, result.code) &&
        Objects.equals(this.description, result.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validResponse, code, description);
  }

  public String toStringVerbose() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Result {\n");
    
    sb.append("    validResponse: ").append(toIndentedString(validResponse)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

