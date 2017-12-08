package com.pmz.humble.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmz.humble.dao.UserDAO;
import com.pmz.humble.model.User;
import com.pmz.humble.model.forms.LoginUserForm;
import com.pmz.humble.model.forms.NewUserForm;
import com.pmz.humble.utils.StringUtils;

/**
 * @author pasko
 *
 */
@Service
public class LoginService {
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	private UserDAO userDAO;
	
	public User loginUser(LoginUserForm loginUserForm) {
		if(loginUserForm.getUsername() != null && loginUserForm.getPassword() !=null) {
			User user = userDAO.getUserByName(loginUserForm.getUsername());
			if(user != null) {
				String encodedPassword = StringUtils.encrypt(loginUserForm.getPassword());

				if(encodedPassword.equals(user.getPassword())) {
					LOG.info("Login Service: The form password and the user password match");
					return user;
				}
				LOG.info("Login Service: The form password and the user password do NOT match");
			}			
		}
		
		return null;
	}
}
