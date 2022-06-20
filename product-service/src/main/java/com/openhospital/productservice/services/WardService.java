package com.openhospital.productservice.services;

import com.openhospital.productservice.beans.*;
import com.openhospital.productservice.beans.wards.GetWardsInput;
import com.openhospital.productservice.beans.wards.GetWardsOutput;
import com.openhospital.productservice.beans.wards.WardOutput;
import com.openhospital.productservice.constants.ReturnCodes;
import com.openhospital.productservice.entities.custom.WardDetail;
import com.openhospital.productservice.exceptions.ApplicationException;
import com.openhospital.productservice.repositories.WardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Log4j2
@Configuration
@Service
public class WardService {

	@Autowired
	WardRepository wardRepository;

	public GetWardsOutput getWards(GetWardsInput req) throws ApplicationException {
		GetWardsOutput out = new GetWardsOutput();
		out.setResult(new Result(ReturnCodes.OK));

		log.info("BEGIN WARDS GENERATION");

		List<WardDetail> wardDetails = wardRepository.getWardsByLang(req.getLang());

		for (WardDetail wardDetail :wardDetails) {
			WardOutput ward = new WardOutput();
			ward.setWardId(BigDecimal.valueOf(wardDetail.getWardId()));
			ward.setWardDescription(wardDetail.getWardDescription());
			ward.setWardCode(wardDetail.getWardCode());
			ward.setLang(wardDetail.getLang());
			out.addWardsItem(ward);
		}

		log.debug("getWards: " + out.toString());

		return out;
	}
}
