package com.web.student.search.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.student.search.dao.DepartmentDao;
import com.web.student.search.dto.Department;
import com.web.student.search.repository.DepartmentRepository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private DepartmentRepository dept_repository;
	
	@Override
	public List<Department> findByDepartmentCode() {
		List<Department> getAllDepartment = (List<Department>) dept_repository.findAll();
		return getAllDepartment;
	}

	@Override
	public void createDepartment(Department department) {
		dept_repository.save(department);
		
	}

}
