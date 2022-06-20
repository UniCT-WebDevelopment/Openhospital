package com.openhospital.ecommerce.beans.externalservices.userservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GenericOutput {

    @JsonProperty("result")
    protected Result result;

    /*
    public GenericOutput() {
        this.result = new Result(ReturnCodes.GENERIC_ERROR);
    }
     */

    public GenericOutput(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}