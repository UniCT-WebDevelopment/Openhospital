package com.openhospital.ecommerce.repositories;

import com.openhospital.ecommerce.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

	@Query(value = "SELECT sq_purchase_id.nextval FROM dual", nativeQuery = true)
	public Integer getNextValSequence();

	public List<Purchase> findByPnr(String pnr);

	public Optional<Purchase> findByIdAndPnr(Integer purchaseOrderId, String pnr);

	@Query(value = """
   			SELECT
				p.*
			FROM
				purchase p 
				JOIN userdata u ON p.id = u.purchase_id
			WHERE
			 	u.user_id = :userId
			"""
			, nativeQuery = true)
	List<Purchase> getPurchasesByUserId(@Param("userId") Integer userId);
}
