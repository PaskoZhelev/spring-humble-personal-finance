package com.pmz.humble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmz.humble.dao.RoleDAO;
import com.pmz.humble.dao.TransactionDAO;
import com.pmz.humble.model.Transaction;

/**
 * @author pasko
 *
 */
@Service
public class RoleService {
	
	@Autowired
	private RoleDAO roleDAO;
	
	public void createRole(String username) {
		roleDAO.createRoleForUser(username);
	}
	
}
