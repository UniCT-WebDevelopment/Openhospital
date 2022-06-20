package com.openhospital.userservice.beans.user.edit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openhospital.userservice.beans.GenericOutput;
import com.openhospital.userservice.beans.Result;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.Objects;

/**
 * Output fields structure
 */
@ApiModel(description = "Output fields structure")
@ToString
public class EditUserOutput extends GenericOutput {
  @JsonProperty("userId")
  private Integer userId;

  public EditUserOutput result(Result result) {
    this.result = result;
    return this;
  }

  public EditUserOutput userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * User registered inside the system
   * @return userId
  **/
  @ApiModelProperty(value = "User registered inside the system")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EditUserOutput addUserOutput = (EditUserOutput) o;
    return Objects.equals(this.result, addUserOutput.result) &&
        Objects.equals(this.userId, addUserOutput.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, userId);
  }

  public String toStringVerbose() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddUserOutput {\n");
    
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    proposals: ").append(toIndentedString(userId)).append("\n");
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

