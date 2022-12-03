package by.grsu.rkarachun.tsm.web.security;

import java.io.Serializable;

public class User implements Serializable {
	public User(String email, String password, String surname) {
		super();
		this.email = email;
		this.password = password;
		this.surname = surname;
	}

	private String email;
	private String password;
	private String surname;
	private boolean blocked;

	public boolean isBlocked() {
		return blocked;
	}

	public User setBlocked(boolean blocked) {
		this.blocked = blocked;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}



}
