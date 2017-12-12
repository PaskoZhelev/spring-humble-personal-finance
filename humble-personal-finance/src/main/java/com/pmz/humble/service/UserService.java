package com.pmz.humble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmz.humble.dao.UserDAO;
import com.pmz.humble.model.User;

/**
 * @author pasko
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleService roleService;

	public User getUserByName(String username) {
		return userDAO.getUserByName(username);
	}
	
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}

	public List<User> getAllUsers() {	
		return userDAO.getAllUsers();
	}

	public void createUser(User user) {
		userDAO.createUser(user);
		roleService.createRole(user.getUsername());
	}
	
	public void deleteUser(String username) {
		userDAO.deleteUser(username);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	public boolean doesUsernameExist(String username) {
		User user = userDAO.getUserByName(username);
		return user == null ? false: true;
	}
}
