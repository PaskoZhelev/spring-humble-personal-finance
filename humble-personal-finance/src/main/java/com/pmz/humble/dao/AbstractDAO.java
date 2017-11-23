package com.pmz.humble.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.pmz.humble.interfaces.DAOHelper;

@Transactional
public class AbstractDAO {

	@Autowired
	private DAOHelper daoHelper;
	
	public JdbcTemplate getJdbcTemplate() {
		return daoHelper.getJdbcTemplate();
	}
}
