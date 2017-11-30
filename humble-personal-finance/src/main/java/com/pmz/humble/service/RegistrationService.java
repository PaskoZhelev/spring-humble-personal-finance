package com.pmz.humble.service;

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
	
	@Autowired
	private UserDAO userDAO;
	
	public User registerUser(NewUserForm newUserForm) {
		if(userDAO.getUserByName(newUserForm.getUsername()) == null) {
			User user = new User(newUserForm.getUsername(),
					newUserForm.getPassword(), newUserForm.getEmail(),
					newUserForm.getAmmount(), newUserForm.getCurrency());
			userDAO.createUser(user);
			return user;
		}
		return null;
	}
}
