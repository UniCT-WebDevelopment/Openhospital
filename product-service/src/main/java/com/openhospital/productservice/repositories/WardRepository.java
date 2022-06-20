package com.openhospital.productservice.repositories;

import com.openhospital.productservice.entities.Ward;
import com.openhospital.productservice.entities.custom.WardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, Integer>{
	@Query(value = """
   			SELECT
				w.id as wardId,
				w.ward_code as wardCode,
				wd.description as wardDescription,
				wd.lang as lang
			FROM
				ward w
			 	JOIN ward_descr wd ON w.ward_code = wd.ward_code
			WHERE
			 	w.enabled = TRUE
			 	AND upper(wd.lang) = upper(:lang)
			"""
			, nativeQuery = true)
	public List<WardDetail> getWardsByLang(
			@Param("lang") String lang
	);
	
}
