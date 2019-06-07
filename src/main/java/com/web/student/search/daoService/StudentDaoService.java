package com.web.student.search.daoService;

import java.util.List;

import com.web.student.search.dto.Student;

public interface StudentDaoService {

	public void createOrUpdateStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudent(String username);
	public List<Student> getActiveStudent(boolean flag);
	public List<Student> getInactiveStudent(boolean flag);
	public List<Student> getAllStudentWithDepartment();
	/*public List<Student> getStudentWithProfile();*/
}
