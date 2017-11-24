package com.pmz.humble.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pmz.humble.interfaces.DAOHelper;

public class AbstractDAOHelper implements DAOHelper {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private DataSource dataSource;
	
    public AbstractDAOHelper(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

}
