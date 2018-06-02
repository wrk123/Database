package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;

	@NotNull
	private String email;

	@NotNull
	private String city;

	public User() {
	}

	public User(long id) {
		this.id = id;
	}

	public User(long id, @NotNull String firstName, @NotNull String lastName, @NotNull String email,
			@NotNull String city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
	}
	
	public User(@NotNull String firstName, @NotNull String lastName, @NotNull String email,
			@NotNull String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getCity() {
		return city;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", city="
				+ city + "]";
	}

}
