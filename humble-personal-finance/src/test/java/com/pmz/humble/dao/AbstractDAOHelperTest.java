package com.pmz.humble.dao;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@RunWith(MockitoJUnitRunner.class)
public class AbstractDAOHelperTest {

	@InjectMocks
	private AbstractDAOHelper classUnderTest;
	
	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
    private DataSource dataSource;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testGetJdbcTemplate() {
		assertThat(classUnderTest.getJdbcTemplate(), instanceOf(JdbcTemplate.class));
	}

	@Test
	public void testGetDataSource() {
		assertThat(classUnderTest.getDataSource(), instanceOf(DataSource.class));
	}

}
