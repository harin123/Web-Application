package com.bookstore.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;

/**
 * Basic login form with JSR-303 Annotations for validation
 * 
 */
public class User {

	@NotNull(message = "User name is mandatory")
	@Size(min = 3, max = 40, message = "User name must be 3 to 40 characters")
	private String username;

	@NotNull(message = "Password is mandatory.")
	@Size(min = 4, max = 15, message = "Password must be 4 to 15 characters.")
	private String password;
	
	private String errorMsg;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private String salt;
	public  String getSalt() {
		return salt;
	  }
	
	public void setSalt(String salt) {
		this.salt = salt;
	}

}