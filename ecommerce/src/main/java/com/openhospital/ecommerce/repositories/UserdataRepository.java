package com.openhospital.ecommerce.repositories;

import com.openhospital.ecommerce.entities.Purchase;
import com.openhospital.ecommerce.entities.Userdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserdataRepository extends JpaRepository<Userdata, Integer>{

	@Query(value = "SELECT sq_userdata_id.nextval FROM dual", nativeQuery = true)
	public Integer getNextValSequence();

	List<Userdata> findByPurchase(Purchase purchase);

}
