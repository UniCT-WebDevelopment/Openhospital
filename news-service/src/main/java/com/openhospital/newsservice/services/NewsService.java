package com.openhospital.newsservice.services;

import com.openhospital.newsservice.beans.news.get.GetNewsInput;
import com.openhospital.newsservice.entities.News;
import com.openhospital.newsservice.exceptions.ApplicationException;
import com.openhospital.newsservice.repositories.NewsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Configuration
@Service
public class NewsService {

	@Autowired
	NewsRepository userRepository;

	public List<News> getNews(GetNewsInput req) throws ApplicationException {
		return userRepository.getNewsByLang(req.getLang());
	}
}
