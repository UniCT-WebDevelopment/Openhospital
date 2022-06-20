package com.openhospital.ecommerce.beans.externalservices.newsservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openhospital.ecommerce.beans.externalservices.userservice.Result;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GenericOutput {

    @JsonProperty("result")
    protected com.openhospital.ecommerce.beans.externalservices.userservice.Result result;

    /*
    public GenericOutput() {
        this.result = new Result(ReturnCodes.GENERIC_ERROR);
    }
     */

    public GenericOutput(com.openhospital.ecommerce.beans.externalservices.userservice.Result result) {
        this.result = result;
    }

    public com.openhospital.ecommerce.beans.externalservices.userservice.Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}