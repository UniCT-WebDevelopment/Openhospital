package com.openhospital.userservice.services;

import com.openhospital.userservice.beans.Result;
import com.openhospital.userservice.beans.user.add.AddUserInput;
import com.openhospital.userservice.beans.user.edit.EditUserInput;
import com.openhospital.userservice.beans.user.get.GetUserInput;
import com.openhospital.userservice.beans.user.get.GetUserOutput;
import com.openhospital.userservice.constants.ReturnCodes;
import com.openhospital.userservice.constants.UserType;
import com.openhospital.userservice.entities.User;
import com.openhospital.userservice.exceptions.ApplicationException;
import com.openhospital.userservice.repositories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Log4j2
@Configuration
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User getUser(GetUserInput req) throws ApplicationException {
		List<User> userList = userRepository.getUserByEmail(req.getEmail());

		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}

		return null;
	}

	public User getUser(String email) throws ApplicationException {
		GetUserInput req = new GetUserInput();
		req.setEmail(email);

		return getUser(req);
	}

	public Integer writeUser(AddUserInput addUserInput) {
		Integer userId = userRepository.getNextValSequence();

		User user = new User();
		user.setId(userId);
		user.setName(addUserInput.getName());
		user.setSurname(addUserInput.getSurname());
		user.setEmail(addUserInput.getEmail());
		user.setPassword(addUserInput.getPassword());
		user.setTaxCode(addUserInput.getTaxCode());
		user.setCountry(addUserInput.getCountry());
		user.setCity(addUserInput.getCity());
		user.setProvince(addUserInput.getProvince());
		user.setPostCode(addUserInput.getPostCode());
		user.setAddress(addUserInput.getAddress());
		user.setAddressNumber(addUserInput.getAddressNumber());
		user.setPhone(addUserInput.getPhone());
		user.setConsent1(addUserInput.getConsent1());
		user.setConsent2(addUserInput.getConsent2());
		user.setConsent3(addUserInput.getConsent3());
		user.setInsertTimestamp(Instant.now());
		user.setUpdateTimestamp(Instant.now());
		user.setUserType(UserType.USER.name());
		user.setEnabled(Boolean.TRUE);

		userRepository.save(user);
		userRepository.flush();

		return userId;
	}

	public Integer updateUser(EditUserInput editUserInput) {
		User user = userRepository.getById(editUserInput.getUserId());

		user.setName(editUserInput.getName());
		user.setSurname(editUserInput.getSurname());
		user.setEmail(editUserInput.getEmail());
		user.setPassword(editUserInput.getPassword());
		user.setTaxCode(editUserInput.getTaxCode());
		user.setCountry(editUserInput.getCountry());
		user.setCity(editUserInput.getCity());
		user.setProvince(editUserInput.getProvince());
		user.setPostCode(editUserInput.getPostCode());
		user.setAddress(editUserInput.getAddress());
		user.setAddressNumber(editUserInput.getAddressNumber());
		user.setPhone(editUserInput.getPhone());
		user.setConsent1(editUserInput.getConsent1());
		user.setConsent2(editUserInput.getConsent2());
		user.setConsent3(editUserInput.getConsent3());
		user.setUpdateTimestamp(Instant.now());
		user.setEnabled(Boolean.TRUE);

		userRepository.save(user);
		userRepository.flush();

		return user.getId();
	}
}
