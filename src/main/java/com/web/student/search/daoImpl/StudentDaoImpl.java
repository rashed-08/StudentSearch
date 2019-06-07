package com.web.student.search.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.student.search.dao.StudentDao;
import com.web.student.search.dto.Student;
import com.web.student.search.repository.StudentRepository;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private StudentRepository studentReposity;

	@Override
	public void createOrUpdateStudent(Student student) {
		studentReposity.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> getAllStudents = (List<Student>) studentReposity.findAll();
		return getAllStudents;
	}

	@Override
	public Student getStudent(String username) {
		Student getStudent = studentReposity.findByUsername(username);
		return getStudent;
	}

	@Override
	public List<Student> getActiveStudent(boolean flag) {
		List<Student> getActiveStudent = (List<Student>) studentReposity.findByEnabled(flag);		
		return getActiveStudent;
	}

	@Override
	public List<Student> getInactiveStudent(boolean flag) {
		List<Student> getInactiveStudent = studentReposity.findInactiveStudent(flag);
		return getInactiveStudent;
	}

	@Override
	public List<Student> getStudentWithDepartment() {
		List<Student> getStudentWithDepartment = studentReposity.findStudentWithDepartment();
		return getStudentWithDepartment;
	}

/*	@Override
	public List<Student> getStudentWithProfile() {
		List<Student> getStudentWithProfile = studentReposity.fetchStudentInnerJoin();
		return getStudentWithProfile;
	}*/

}
