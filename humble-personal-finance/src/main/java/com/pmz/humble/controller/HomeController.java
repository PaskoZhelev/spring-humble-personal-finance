package com.pmz.humble.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pmz.humble.handler.CalculationHandler;
import com.pmz.humble.model.User;
import com.pmz.humble.service.UserService;

/**
 * @author pasko
 *
 */
@Controller
public class HomeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;	
	@Autowired
	private CalculationHandler calculationHandler;
	
	@GetMapping(value= {"/","/home"})
	public String getIndex(Model model) {
		addNecessaryModelAttributes(getLoggedUser(), model);

		return "home";
	}

	/**
	 * @return current User
	 */
	private User getLoggedUser() {
		String username  = SecurityContextHolder.getContext().getAuthentication().getName();	//receive the username of the logged in user
		User user = userService.getUserByName(username);
		return user;
	}
	//TODO may create a UserTransactions model in which to use calculationHandler for calculating all transaction of the user
	private void addNecessaryModelAttributes(final User user, final Model model) {
		model.addAttribute("user", user);
		
		LOG.info("Logged in user: {}", user.toString());
	}
}
