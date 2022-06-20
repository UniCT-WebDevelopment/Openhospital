package com.openhospital.userservice.beans.user.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openhospital.userservice.beans.GenericOutput;
import com.openhospital.userservice.beans.Result;
import com.openhospital.userservice.entities.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.Objects;

/**
 * Output fields structure
 */
@ApiModel(description = "Output fields structure")
@ToString
public class GetUserOutput extends GenericOutput {
  @JsonProperty("user")
  private User user = null;

  public GetUserOutput result(Result result) {
    this.result = result;
    return this;
  }

  public GetUserOutput user(User user) {
    this.user = user;
    return this;
  }

   /**
   * User registered inside the system
   * @return user
  **/
  @ApiModelProperty(value = "User registered inside the system")
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUserOutput getUserOutput = (GetUserOutput) o;
    return Objects.equals(this.result, getUserOutput.result) &&
        Objects.equals(this.user, getUserOutput.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, user);
  }

  public String toStringVerbose() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUserOutput {\n");
    
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    proposals: ").append(toIndentedString(user)).append("\n");
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

