package com.web.student.search.dao;

import java.util.List;

import com.web.student.search.dto.Student;

public interface StudentDao {

	public void createOrUpdateStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudent(String username);
	public List<Student> getActiveStudent(boolean flag);
	public List<Student> getInactiveStudent(boolean flag);
	public List<Student> getStudentWithDepartment();
	/*public List<Student> getStudentWithProfile();*/
}
