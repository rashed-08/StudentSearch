package com.web.student.search.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@NotNull
	@Column(name="dept_code")
	private String departmentCode;
	
	@NotNull
	@Column(name="dept_name")
	private String departmentName;
	
	public Department() {
		
	}

	public Department(String departmentCode, String departmentName) {
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
