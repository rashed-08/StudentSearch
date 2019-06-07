package com.web.student.search.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "student_profile")
public class StudentProfile implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String student;

	@Basic
	@Column(name = "birth_date")
	private Date birthDate;

	@Basic
	@Column(name = "ssc_year")
	private Date SSCYear;

	@Basic
	@Column(name = "hsc_year")
	private Date HSCYear;

	@Column(name = "department_name")
	private String departmentName;

	@Basic
	@Column(name = "admission_year")
	private Date admissionYear;

	@Column(name = "current_semester")
	private String currentSemester;

	public StudentProfile() {

	}

	public StudentProfile(String student, Date birthDate, Date sSCYear, Date hSCYear, String departmentName,
			Date admissionYear, String currentSemester) {
		this.student = student;
		this.birthDate = birthDate;
		SSCYear = sSCYear;
		HSCYear = hSCYear;
		this.departmentName = departmentName;
		this.admissionYear = admissionYear;
		this.currentSemester = currentSemester;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return student;
	}

	public void setUsername(String student) {
		this.student = student;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getSSCYear() {
		return SSCYear;
	}

	public void setSSCYear(Date sSCYear) {
		SSCYear = sSCYear;
	}

	public Date getHSCYear() {
		return HSCYear;
	}

	public void setHSCYear(Date hSCYear) {
		HSCYear = hSCYear;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Date getAdmissionYear() {
		return admissionYear;
	}

	public void setAdmissionYear(Date admissionYear) {
		this.admissionYear = admissionYear;
	}

	public String getCurrentSemester() {
		return currentSemester;
	}

	public void setCurrentSemester(String currentSemester) {
		this.currentSemester = currentSemester;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

}
