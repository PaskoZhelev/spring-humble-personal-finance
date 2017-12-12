package com.pmz.humble.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author pasko
 *
 */
@Configuration
@EnableWebSecurity
public class MvcConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/register").permitAll()
			.antMatchers("/", "/home").access("hasRole('ROLE_USER')")
			.and()
		.formLogin().loginPage("/login-page").usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/home").permitAll()
		.and()
		.logout().permitAll();				
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery(
					   "select username,password, enabled from users where username=?")
					  .authoritiesByUsernameQuery(
					   "select rl_username, role from user_roles where rl_username=?")
					  .passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
}
