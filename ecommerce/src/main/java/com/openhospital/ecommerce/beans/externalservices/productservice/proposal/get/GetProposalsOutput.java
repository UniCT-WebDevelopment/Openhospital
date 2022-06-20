package com.openhospital.ecommerce.beans.externalservices.productservice.proposal.get;

import com.openhospital.ecommerce.beans.externalservices.productservice.Result;
import lombok.Data;
import lombok.ToString;
import java.util.List;

@Data
@ToString
public class GetProposalsOutput{
  protected Result result;
  private List<OutputProposal> proposals;

  public GetProposalsOutput() {
  }

  public GetProposalsOutput(Result result) {
    this.result = result;
  }

  public GetProposalsOutput(Result result, List<OutputProposal> proposals) {
    this.result = result;
    this.proposals = proposals;
  }

}