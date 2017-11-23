package com.pmz.humble.interfaces;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public interface DAOHelper {
	
    /**
     * Returns a JDBC template for performing database operations.
     *
     * @return A JDBC template.
     */
	JdbcTemplate getJdbcTemplate();
	
	DataSource getDataSource();
	
}
