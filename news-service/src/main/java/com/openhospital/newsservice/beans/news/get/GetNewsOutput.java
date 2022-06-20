package com.openhospital.newsservice.beans.news.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openhospital.newsservice.beans.GenericOutput;
import com.openhospital.newsservice.beans.Result;
import com.openhospital.newsservice.entities.News;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

/**
 * Output fields structure
 */
@ApiModel(description = "Output fields structure")
@ToString
public class GetNewsOutput extends GenericOutput {
  @JsonProperty("news")
  private List<News> news = null;

  public GetNewsOutput result(Result result) {
    this.result = result;
    return this;
  }

  public GetNewsOutput news(List<News> news) {
    this.news = news;
    return this;
  }

   /**
   * News registered inside the system
   * @return news
  **/
  @ApiModelProperty(value = "News registered inside the system")
  public List<News> getNews() {
    return news;
  }

  public void setNews(List<News> news) {
    this.news = news;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetNewsOutput getProposalsOutput = (GetNewsOutput) o;
    return Objects.equals(this.result, getProposalsOutput.result) &&
        Objects.equals(this.news, getProposalsOutput.news);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, news);
  }

  public String toStringVerbose() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetNewsOutput {\n");

    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    proposals: ").append(toIndentedString(news)).append("\n");
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

