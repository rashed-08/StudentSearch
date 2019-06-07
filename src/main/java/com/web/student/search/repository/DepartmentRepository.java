package com.web.student.search.repository;

import org.springframework.data.repository.CrudRepository;

import com.web.student.search.dto.Department;

public interface DepartmentRepository extends CrudRepository<Department, String>{

}
