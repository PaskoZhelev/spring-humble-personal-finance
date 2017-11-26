package com.pmz.humble.dao;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pmz.humble.interfaces.DAOHelper;


public class AbstractDAO {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractDAO.class);
	
	@Autowired
	private DAOHelper daoHelper;
	
	
		
	/**
     * Returns a JDBC template for performing database operations.
     * @return A JDBC template.
     */
	public JdbcTemplate getJdbcTemplate() {
		return daoHelper.getJdbcTemplate();
	}
	
    private void log(String sql, long startTimeNano) {
        long millis = (System.nanoTime() - startTimeNano) / 1000000L;

        // Log queries that take more than 2 seconds.
        if (millis > TimeUnit.SECONDS.toMillis(2L)) {
            LOG.debug("{} ms:  {}",millis,sql);
        }
    }
    
    
	
	protected int update(String sql, Object... args) {
        long time = System.nanoTime();
        LOG.trace("Executing query: [{}]", sql);
        int result = getJdbcTemplate().update(sql, args);
        LOG.trace("Updated {} rows", result);
        log(sql, time);
        return result;
    }
	
	protected <T> List<T> query(String sql, RowMapper rowMapper, Object... args) {
        long t = System.nanoTime();
        List<T> result = getJdbcTemplate().query(sql, args, rowMapper);
        log(sql, t);
        return result;
    }
	
	protected <T> T queryOne(String sql, RowMapper rowMapper, Object... args) {
        List<T> list = query(sql, rowMapper, args);
        return list.isEmpty() ? null : list.get(0);
    }
	
	protected List<String> queryForStrings(String sql, Object... args) {
        long t = System.nanoTime();
        List<String> result = getJdbcTemplate().queryForList(sql, args, String.class);
        log(sql, t);
        return result;
    }

    protected List<Integer> queryForInts(String sql, Object... args) {
        long t = System.nanoTime();
        List<Integer> result = getJdbcTemplate().queryForList(sql, args, Integer.class);
        log(sql, t);
        return result;
    }
    
    protected Date queryForDate(String sql, Date defaultValue, Object... args) {
        long t = System.nanoTime();
        List<Date> list = getJdbcTemplate().queryForList(sql, args, Date.class);
        Date result = list.isEmpty() ? defaultValue : list.get(0) == null ? defaultValue : list.get(0);
        log(sql, t);
        return result;
    }

    protected Long queryForLong(String sql, Long defaultValue, Object... args) {
        long t = System.nanoTime();
        List<Long> list = getJdbcTemplate().queryForList(sql, args, Long.class);
        Long result = list.isEmpty() ? defaultValue : list.get(0) == null ? defaultValue : list.get(0);
        log(sql, t);
        return result;
    }

	public DAOHelper getDaoHelper() {
		return daoHelper;
	}

	public void setDaoHelper(DAOHelper daoHelper) {
		this.daoHelper = daoHelper;
	}
    
    
}
