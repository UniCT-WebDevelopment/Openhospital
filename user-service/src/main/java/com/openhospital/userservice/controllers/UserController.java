package com.openhospital.userservice.controllers;


import com.openhospital.userservice.beans.Result;
import com.openhospital.userservice.beans.user.add.AddUserInput;
import com.openhospital.userservice.beans.user.add.AddUserOutput;
import com.openhospital.userservice.beans.user.edit.EditUserInput;
import com.openhospital.userservice.beans.user.edit.EditUserOutput;
import com.openhospital.userservice.beans.user.get.GetUserInput;
import com.openhospital.userservice.beans.user.get.GetUserOutput;
import com.openhospital.userservice.constants.ReturnCodes;
import com.openhospital.userservice.entities.User;
import com.openhospital.userservice.exceptions.ApplicationException;
import com.openhospital.userservice.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@ControllerAdvice

@RequestMapping(value = "/user-service/v1", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE })
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/getUser", method = { RequestMethod.POST })
	public ResponseEntity<GetUserOutput> getUser(@RequestBody GetUserInput req, BindingResult result)
			throws ApplicationException {

		log.debug("START - getUser");

		GetUserOutput getUserOutput = new GetUserOutput();
		getUserOutput.setResult(new Result(ReturnCodes.OK));

		if (req.getEmail() == null || req.getEmail().isBlank()) {
			getUserOutput.setResult(new Result(ReturnCodes.MISSING_PARAMETERS));
		}


		if (getUserOutput.getResult().getCode().equals(ReturnCodes.OK.getCode())) {
			User user = userService.getUser(req);
			getUserOutput.setUser(user);
		}

		log.debug("END - getUser");

		return new ResponseEntity<GetUserOutput>(getUserOutput, HttpStatus.OK);
	}

	@RequestMapping(value = "/addUser", method = { RequestMethod.POST })
	public ResponseEntity<AddUserOutput> addUser(@RequestBody AddUserInput req, BindingResult result)
			throws ApplicationException {

		log.debug("START - addUser");
		log.debug("req [" + req + "]");

		AddUserOutput addUserOutput = new AddUserOutput();
		addUserOutput.setResult(new Result(ReturnCodes.OK));

		if (req.getName() == null || req.getName().isBlank() ||
				req.getSurname() == null || req.getSurname().isBlank() ||
				req.getEmail() == null || req.getEmail().isBlank() ||
				req.getPassword() == null || req.getPassword().isBlank() ||
				req.getTaxCode() == null || req.getTaxCode().isBlank() ||
				req.getCountry() == null || req.getCountry().isBlank() ||
				req.getCity() == null || req.getCity().isBlank() ||
				req.getProvince() == null || req.getProvince().isBlank() ||
				req.getPostCode() == null || req.getPostCode().isBlank() ||
				req.getAddress() == null || req.getAddress().isBlank() ||
				req.getAddressNumber() == null || req.getAddressNumber().isBlank() ||
				req.getPhone() == null || req.getPhone().isBlank() ||
				req.getConsent1() == null ||
				req.getConsent2() == null ||
				req.getConsent3() == null ||
				req.getUserType() == null || req.getUserType().isBlank()
		) {
			addUserOutput.setResult(new Result(ReturnCodes.MISSING_PARAMETERS));
		}
		if (req.getEmail() != null) {
			User user = userService.getUser(req.getEmail());
			if (user != null) {
				addUserOutput.setResult(new Result(ReturnCodes.OP_NOT_PERMITTED));
			}
		}
		if (req.getConsent1() != null && req.getConsent1().equals(Boolean.FALSE)){
			addUserOutput.setResult(new Result(ReturnCodes.OP_NOT_PERMITTED));
		}


		if (addUserOutput.getResult().getCode().equals(ReturnCodes.OK.getCode())) {
			Integer userId = userService.writeUser(req);
			addUserOutput.setUserId(userId);
		}

		log.debug("END - addUser");

		return new ResponseEntity<AddUserOutput>(addUserOutput, HttpStatus.OK);
	}



	@RequestMapping(value = "/editUser", method = { RequestMethod.POST })
	public ResponseEntity<EditUserOutput> editUser(@RequestBody EditUserInput req, BindingResult result)
			throws ApplicationException {

		log.debug("START - editUser");
		log.debug("req [" + req + "]");

		EditUserOutput editUserOutput = new EditUserOutput();
		editUserOutput.setResult(new Result(ReturnCodes.OK));

		if (req.getUserId() == null ||
				req.getName() == null || req.getName().isBlank() ||
				req.getSurname() == null || req.getSurname().isBlank() ||
				req.getEmail() == null || req.getEmail().isBlank() ||
				req.getPassword() == null || req.getPassword().isBlank() ||
				req.getTaxCode() == null || req.getTaxCode().isBlank() ||
				req.getCountry() == null || req.getCountry().isBlank() ||
				req.getCity() == null || req.getCity().isBlank() ||
				req.getProvince() == null || req.getProvince().isBlank() ||
				req.getPostCode() == null || req.getPostCode().isBlank() ||
				req.getAddress() == null || req.getAddress().isBlank() ||
				req.getAddressNumber() == null || req.getAddressNumber().isBlank() ||
				req.getPhone() == null || req.getPhone().isBlank() ||
				req.getConsent1() == null ||
				req.getConsent2() == null ||
				req.getConsent3() == null
		) {
			editUserOutput.setResult(new Result(ReturnCodes.MISSING_PARAMETERS));
		}
		if (req.getEmail() != null) {
			User user = userService.getUser(req.getEmail());
			if (user != null && user.getId() != req.getUserId()) {
				editUserOutput.setResult(new Result(ReturnCodes.OP_NOT_PERMITTED));
			}
		}
		if (req.getConsent1() != null && req.getConsent1().equals(Boolean.FALSE)){
			editUserOutput.setResult(new Result(ReturnCodes.OP_NOT_PERMITTED));
		}


		if (editUserOutput.getResult().getCode().equals(ReturnCodes.OK.getCode())) {
			Integer userId = userService.updateUser(req);
			editUserOutput.setUserId(userId);
		}

		log.debug("END - editUser");

		return new ResponseEntity<EditUserOutput>(editUserOutput, HttpStatus.OK);
	}

}