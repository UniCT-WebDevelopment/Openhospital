package com.openhospital.productservice.repositories;

import com.openhospital.productservice.entities.Doctor;
import com.openhospital.productservice.entities.custom.DoctorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	@Query(value = """
   			SELECT
				d.id as id,
				d.name as name,
				d.surname as surname,
				d.email as email,
				d.mobile_phone as mobilePhone,
				d.office_phone as officePhone,
				d.ward_code as wardCode,
				wd.description as wardDescription,
				0 as price
			FROM
				doctor d
			 	JOIN ward w ON d.ward_code = w.ward_code
			 	JOIN ward_descr wd ON w.ward_code = wd.ward_code
			WHERE
			 	w.enabled = true
			 	AND upper(d.ward_code) = upper(:wardCode)
				AND (
					:doctorName is null
					OR concat(upper(d.name), ' ', upper(d.surname)) like concat('%', upper(:doctorName), '%')
					OR concat(upper(d.surname), ' ', upper(d.name)) like concat('%', upper(:doctorName), '%')
				)
			 	AND upper(wd.lang) = upper(:lang)
			"""
			, nativeQuery = true)
	public List<DoctorDetail> getDoctorByWardCodeDoctorNameAndLang(
			@Param("wardCode") String wardCode,
			@Param("doctorName") String doctorName,
			@Param("lang") String lang
	);
	
}
