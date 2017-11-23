package com.pmz.humble.dao;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pmz.humble.interfaces.DAOHelper;

@RunWith(MockitoJUnitRunner.class)
public class AbstractDAOTest {

	@InjectMocks
	private AbstractDAO classUnderTest;
	
	@Mock
	private DAOHelper daoHelper;
	
	@Before
    public void setUp(){
		MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testGetJdbcTemplate() {
		when(daoHelper.getJdbcTemplate()).thenReturn(new JdbcTemplate());
		classUnderTest.getJdbcTemplate();
		verify(daoHelper).getJdbcTemplate();
		assertThat(classUnderTest.getJdbcTemplate(), instanceOf(JdbcTemplate.class));
	}

}
