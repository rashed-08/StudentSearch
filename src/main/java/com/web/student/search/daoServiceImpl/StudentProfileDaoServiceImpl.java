package com.web.student.search.daoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.student.search.daoImpl.StudentProfileDaoImpl;
import com.web.student.search.daoService.StudentProfileDaoService;
import com.web.student.search.dto.StudentProfile;

@Service
public class StudentProfileDaoServiceImpl implements StudentProfileDaoService {

	@Autowired
	private StudentProfileDaoImpl studentProfileImpl;
	
	@Override
	public void createStudentProfile(StudentProfile studentProfile) {
		studentProfileImpl.createStudentProfile(studentProfile);
	}

	@Override
	public StudentProfile getProfile(String username) {
		StudentProfile getProfile = studentProfileImpl.getProfile(username);
		return getProfile;
	}

}
