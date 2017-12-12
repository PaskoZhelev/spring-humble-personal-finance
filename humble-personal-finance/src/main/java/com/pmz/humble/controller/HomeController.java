package com.pmz.humble.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pmz.humble.dao.TransactionDAO;
import com.pmz.humble.dao.UserDAO;

/**
 * @author pasko
 *
 */
@Controller
public class HomeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping(value= {"/","/home"})
	public String getIndex() {
		
		return "home";
	}
		
}
