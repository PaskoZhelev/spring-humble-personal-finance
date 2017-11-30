package com.pmz.humble.model.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author pasko
 *
 */
public class NewUserForm {
	
	@NotNull
	@Size(min=3, max=20)
	private String username;
	
	@NotNull
	@Size(min=6)
	private String password;
	
	@NotNull
	@Size(min=6)
	@Email
	private String email;
	
	@Min(value=0, message="Invalid amount")
	private double ammount;
	
	private int currency;	

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

}
