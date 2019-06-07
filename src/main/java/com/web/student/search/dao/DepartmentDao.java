package com.web.student.search.dao;

import java.util.List;

import com.web.student.search.dto.Department;

public interface DepartmentDao {

	public List<Department> findByDepartmentCode();
	public void createDepartment(Department department);
}
