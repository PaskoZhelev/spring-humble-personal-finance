package com.pmz.humble.dao;

import org.springframework.stereotype.Component;

import com.pmz.humble.utils.QueryUtils;

/**
 * @author pasko
 *
 */
@Component
public class RoleDAO extends AbstractDAO {
	
	private static final String ROLE_COLUMNS = "rl_username, role";
	private static final String USER_ROLE = "ROLE_USER";
	
	
	public void createRoleForUser(String username) {
		String sql = QueryUtils.getInsertStatement("user_roles", ROLE_COLUMNS);      
        update(sql, username, USER_ROLE);
	}
		
}
