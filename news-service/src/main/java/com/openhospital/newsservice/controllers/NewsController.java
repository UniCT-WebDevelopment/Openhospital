package com.openhospital.newsservice.controllers;


import com.openhospital.newsservice.beans.Result;
import com.openhospital.newsservice.beans.news.get.GetNewsInput;
import com.openhospital.newsservice.beans.news.get.GetNewsOutput;
import com.openhospital.newsservice.constants.Lang;
import com.openhospital.newsservice.constants.ReturnCodes;
import com.openhospital.newsservice.entities.News;
import com.openhospital.newsservice.exceptions.ApplicationException;
import com.openhospital.newsservice.services.NewsService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@ControllerAdvice

@RequestMapping(value = "/news-service/v1", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE })
public class NewsController {

	@Autowired
	NewsService newsService;

	@RequestMapping(value = "/getNews", method = { RequestMethod.POST })
	public ResponseEntity<GetNewsOutput> getNews(@RequestBody GetNewsInput req, BindingResult result)
			throws ApplicationException {

		log.debug("START - getNews");

		GetNewsOutput getNewsOutput = new GetNewsOutput();
		getNewsOutput.setResult(new Result(ReturnCodes.OK));

		if (req.getLang() == null || !EnumUtils.isValidEnum(Lang.class, req.getLang().toUpperCase())) {
			getNewsOutput.setResult(new Result(ReturnCodes.LANGUAGE_NOT_VALID));
		}


		if (getNewsOutput.getResult().getCode().equals(ReturnCodes.OK.getCode())) {
			List<News> news = newsService.getNews(req);
			getNewsOutput.setNews(news);
		}

		log.debug("END - getNews");

		return new ResponseEntity<GetNewsOutput>(getNewsOutput, HttpStatus.OK);
	}

}