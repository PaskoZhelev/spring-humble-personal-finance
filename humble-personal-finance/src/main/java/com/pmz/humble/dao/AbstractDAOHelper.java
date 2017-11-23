package com.pmz.humble.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pmz.humble.interfaces.DAOHelper;

public class AbstractDAOHelper implements DAOHelper {
	
	private JdbcTemplate jdbcTemplate;

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
