package com.openhospital.ecommerce.repositories;

import com.openhospital.ecommerce.entities.Product;
import com.openhospital.ecommerce.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query(value = "SELECT sq_product_id.nextval FROM dual", nativeQuery = true)
	public Integer getNextValSequence();

	List<Product> findByPurchase(Purchase purchase);

	List<Product> findByPurchaseAndProposalId(Purchase purchase, Integer proposalId);

}
