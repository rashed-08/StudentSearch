package com.web.student.search.daoServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.student.search.daoImpl.DepartmentDaoImpl;
import com.web.student.search.daoService.DepartmentDaoService;
import com.web.student.search.dto.Department;

@Service
public class DepartmentDaoServiceImpl implements DepartmentDaoService {
	
	@Autowired
	private DepartmentDaoImpl dept_dao;

	@Override
	public List<Department> getAllDepartment() {
		List<Department> getAllDepartment = dept_dao.findByDepartmentCode();
		return getAllDepartment;
	}

	@Override
	public void createDepartment(Department department) {
		dept_dao.createDepartment(department);
	}

}
