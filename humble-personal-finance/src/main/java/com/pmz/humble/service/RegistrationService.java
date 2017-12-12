package com.pmz.humble.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmz.humble.dao.UserDAO;
import com.pmz.humble.model.User;
import com.pmz.humble.model.forms.NewUserForm;

/**
 * @author pasko
 *
 */
@Service
public class RegistrationService {
	
	private static final Logger LOG = LoggerFactory.getLogger(RegistrationService.class);
	
	@Autowired
	private UserService userService;
	
	public User registerUser(NewUserForm newUserForm) {
		if(userService.getUserByName(newUserForm.getUsername()) == null) {
			User user = new User(newUserForm.getUsername(),
					newUserForm.getPassword(), newUserForm.getEmail(),
					newUserForm.getAmmount(), newUserForm.getCurrency());
			userService.createUser(user);
			LOG.info("Successfully created user: {}", user.toString());
			
			return user;
		}
		return null;
	}
}
