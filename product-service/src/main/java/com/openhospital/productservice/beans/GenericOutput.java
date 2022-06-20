package com.openhospital.productservice.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openhospital.productservice.constants.ReturnCodes;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@ToString
public class GenericOutput {
    @JsonProperty("result")
    protected Result result = null;

    public GenericOutput(){
        this.result = new Result(ReturnCodes.GENERIC_ERROR);
    }

    public GenericOutput(Result result) {
        this.result = result;
    }
    
    /**
     * Get result
     * @return result
     **/
    @ApiModelProperty(value = "")
    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
