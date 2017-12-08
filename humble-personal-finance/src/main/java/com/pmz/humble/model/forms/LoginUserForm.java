package com.pmz.humble.model.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author pasko
 *
 */
public class LoginUserForm {
	
	@NotNull(message="Username field cannot be empty")
	@Size(min=3, max=20,message="Username must be between {min} and {max} symbols")
	private String username;
	
	@NotNull(message="Password field cannot be empty")
	@Size(max=100,message="Password must be maximum {max} symbols")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
