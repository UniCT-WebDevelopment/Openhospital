package com.openhospital.productservice.repositories;

import com.openhospital.productservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	@Query(value = "SELECT sq_reservation_id.nextval FROM dual", nativeQuery = true)
	public Integer getNextValSequence();

	
}
