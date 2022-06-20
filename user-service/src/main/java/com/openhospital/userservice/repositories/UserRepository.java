package com.openhospital.userservice.repositories;

import com.openhospital.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "SELECT sq_user_id.nextval FROM dual", nativeQuery = true)
	public Integer getNextValSequence();

	@Query(value = """
   			SELECT
				*
			FROM
				user
			WHERE
			 	enabled = true
			 	AND upper(email) = upper(:email)
			"""
			, nativeQuery = true)
	public List<User> getUserByEmail(
			@Param("email") String email
	);

}
