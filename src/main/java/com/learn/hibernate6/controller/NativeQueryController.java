package com.learn.hibernate6.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.learn.hibernate6.model.User;
import com.learn.hibernate6.model.dto.OrderTupleForUser;
import com.learn.hibernate6.repository.UserNativeQuerryRepository;

@Slf4j
@RestController
public class NativeQueryController {
	
	final
	UserNativeQuerryRepository userNativeQuerryRepository;

	public NativeQueryController(UserNativeQuerryRepository userNativeQuerryRepository) {
		this.userNativeQuerryRepository = userNativeQuerryRepository;
	}

	@GetMapping(value = "/listOfUsers")
	public List<User> getMethodName() {

		return userNativeQuerryRepository.getListOfUsers();
	}
	@GetMapping(value = "/orderlist/{userid}")
	public List<OrderTupleForUser>	getOrderHistoryForUser(@PathVariable(value="userid") Integer userid) {
		return userNativeQuerryRepository.getPurchaceHistoryOfUser(userid);
	}


}
