package com.openhospital.newsservice.repositories;

import com.openhospital.newsservice.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer>{
	@Query(value = """
   			SELECT
				*
			FROM
				news
			WHERE
			 	enabled = true
			 	AND upper(lang) = upper(:lang)
			"""
			, nativeQuery = true)
	public List<News> getNewsByLang(
			@Param("lang") String lang
	);
	
}
