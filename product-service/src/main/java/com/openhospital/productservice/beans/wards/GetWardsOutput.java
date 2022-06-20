package com.openhospital.productservice.beans.wards;

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
 * Output fields structure
 */
@ApiModel(description = "Output fields structure")
@ToString
public class GetWardsOutput extends GenericOutput {
  @JsonProperty("wards")
  private List<WardOutput> wards = null;

  public GetWardsOutput result(Result result) {
    this.result = result;
    return this;
  }

  public GetWardsOutput wards(List<WardOutput> wards) {
    this.wards = wards;
    return this;
  }

  public GetWardsOutput addWardsItem(WardOutput wardsItem) {
    if (this.wards == null) {
      this.wards = new ArrayList<WardOutput>();
    }
    this.wards.add(wardsItem);
    return this;
  }

   /**
   * Wards array generated by the system
   * @return wards
  **/
  @ApiModelProperty(value = "Proposals array generated by the system")
  public List<WardOutput> getWards() {
    return wards;
  }

  public void setWards(List<WardOutput> proposals) {
    this.wards = wards;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetWardsOutput getWardsOutput = (GetWardsOutput) o;
    return Objects.equals(this.result, getWardsOutput.result) &&
        Objects.equals(this.wards, getWardsOutput.wards);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, wards);
  }

  public String toStringVerbose() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetWardsOutput {\n");
    
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    wards: ").append(toIndentedString(wards)).append("\n");
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

