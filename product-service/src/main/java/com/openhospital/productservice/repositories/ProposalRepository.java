package com.openhospital.productservice.repositories;

import com.openhospital.productservice.entities.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProposalRepository extends JpaRepository<Proposal, Integer>{

	@Query(value = "SELECT sq_proposal_id.nextval FROM dual", nativeQuery = true)
	public Integer getNextValSequence();

	
}
