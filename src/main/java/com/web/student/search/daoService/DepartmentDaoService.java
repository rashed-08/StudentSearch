package com.web.student.search.daoService;

import java.util.List;

import com.web.student.search.dto.Department;

public interface DepartmentDaoService {

	public List<Department> getAllDepartment();
	public void createDepartment(Department department);
}
