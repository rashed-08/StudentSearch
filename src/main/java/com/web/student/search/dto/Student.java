package com.web.student.search.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@NotNull
	@Size(min = 2, max = 20, message="Username must be contain more than 2 or less than 20 characters")
	private String username;
	
	@NotNull
	@Column(name = "first_name")
	@Size(min=2, max=30, message="First name must be contain more than 2 or less than 30 characters")
	private String firstName;
	
	@NotNull
	@Size(min=2, max=30, message="Last name must be contain more than 2 or less than 30 characters")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Email(message="Please provide valid email")
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	@Column(name = "promo_code")
	private String promoCode;
	private boolean enabled;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Authority authorities;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private StudentProfile profile;

	public Student(String username, String firstName, String lastName, String email, String password, String promoCode,
			boolean enabled) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.promoCode = promoCode;
		this.enabled = enabled;
	}

	public Student() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStudentId() {
		return username;
	}

	public void setStudentId(String studentId) {
		this.username = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Authority getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authority authorities) {
		this.authorities = authorities;
	}

	public StudentProfile getProfile() {
		return profile; 
	}

	public void setProfile(StudentProfile profile) {
		this.profile = profile;
	}

}
