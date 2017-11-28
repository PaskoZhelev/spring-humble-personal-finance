package com.pmz.humble.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import com.pmz.humble.interfaces.DAOHelper;
import com.pmz.humble.model.User;

/**
 * @author pasko
 *
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class UserDAOTest {

	@InjectMocks
	private UserDAO classUnderTest;
	
	@Mock
	private DAOHelper daoHelper;
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@Mock
	private DataSource dataSource;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);	
		jdbcTemplate = new JdbcTemplate();
	}


	@Test
	public void testGetUserByName() {
		when(daoHelper.getJdbcTemplate()).thenReturn(jdbcTemplate);
		when(daoHelper.getDataSource()).thenReturn(dataSource);
		User newUser = new User("test2", "test", "test@example", new java.sql.Date(System.currentTimeMillis()), 100.00, 1);
		classUnderTest.createUser(newUser);
		
		User user = classUnderTest.getUserByName("test");	
		assertNotNull("It is null", user);
	}

}
