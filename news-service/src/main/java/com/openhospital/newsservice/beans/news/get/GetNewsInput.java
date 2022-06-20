package com.openhospital.newsservice.beans.news.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@ApiModel(description = "getNews call let you receive news")
@ToString
public class GetNewsInput {

  @JsonProperty("lang")
  private String lang = null;


  /**
   * User lang
   * @return lang
   **/
  @ApiModelProperty(required = true, value = "User lang")
  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

}

