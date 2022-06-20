package com.openhospital.ecommerce.beans.externalservices.newsservice.get;

import com.openhospital.ecommerce.beans.externalservices.newsservice.Result;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class GetNewsOutput {
  protected Result result;
  private List<News> news;

  public GetNewsOutput() {
  }

  public GetNewsOutput(Result result) {
    this.result = result;
  }

  public GetNewsOutput(Result result, List<News> news) {
    this.result = result;
    this.news = news;
  }

}