package com.openhospital.productservice.repositories;

import com.openhospital.productservice.entities.Health;
import com.openhospital.productservice.entities.custom.HealthDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HealthRepository extends JpaRepository<Health, Integer>{
	@Query(value = """
   			SELECT
				h.id as id,
				h.ward_code as wardCode,
				wd.description as wardDescription,
				hd.description as healthDescription,
				hd.info as healthInfo,
				h.price as price
			FROM
				health h
			 	JOIN health_descr hd ON h.id = hd.health_id
			 	JOIN ward_descr wd ON (h.ward_code = wd.ward_code AND upper(hd.lang) = upper(wd.lang))
			WHERE
			 	h.enabled = true
			 	AND upper(h.ward_code) = upper(:wardCode)
			 	AND upper(hd.lang) = upper(:lang)
			"""
			, nativeQuery = true)
	public List<HealthDetail> getHealthByWardCodeAndLang(
			@Param("wardCode") String wardCode,
			@Param("lang") String lang
	);
	
}
