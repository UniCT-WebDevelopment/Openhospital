package com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock;

import com.openhospital.ecommerce.beans.externalservices.productservice.Result;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class LockProposalsOutput {
  protected Result result;
  private List<OutputReservation> reservations;

  public LockProposalsOutput() {
  }

  public LockProposalsOutput(Result result) {
    this.result = result;
  }

  public LockProposalsOutput(Result result, List<OutputReservation> reservations) {
    this.result = result;
    this.reservations = reservations;
  }

}