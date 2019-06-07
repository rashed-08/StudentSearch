package com.web.student.search.daoServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.student.search.daoImpl.StudentDaoImpl;
import com.web.student.search.daoService.StudentDaoService;
import com.web.student.search.dto.Student;

@Service
public class StudentDaoServiceImpl implements StudentDaoService{

	@Autowired
	private StudentDaoImpl studentDaoImpl;
	
	@Override
	public void createOrUpdateStudent(Student student) {
		studentDaoImpl.createOrUpdateStudent(student);
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> getAllStudent = (List<Student>) studentDaoImpl.getAllStudent();
		return getAllStudent;
	}

	@Override
	public Student getStudent(String username) {
		Student getStudent = studentDaoImpl.getStudent(username);
		return getStudent;
	}

	@Override
	public List<Student> getActiveStudent(boolean flag) {
		List<Student> getAllActiveStudent = studentDaoImpl.getActiveStudent(flag);
		return getAllActiveStudent;
	}

	@Override
	public List<Student> getInactiveStudent(boolean flag) {
		List<Student> getAllInactiveStudent = studentDaoImpl.getInactiveStudent(flag);
		return getAllInactiveStudent;
	}

	@Override
	public List<Student> getAllStudentWithDepartment() {
		List<Student> getAllStudentWithDepartment = studentDaoImpl.getStudentWithDepartment();
		return getAllStudentWithDepartment;
	}

	/*@Override
	public List<Student> getStudentWithProfile() {
		List<Student> getStudentWithProfile = studentDaoImpl.getStudentWithProfile();
		return getStudentWithProfile;
	}*/

}
