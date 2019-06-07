package com.web.student.search.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.student.search.dao.StudentProfileDao;
import com.web.student.search.dto.StudentProfile;
import com.web.student.search.repository.StudentProfileRepository;

@Repository
public class StudentProfileDaoImpl implements StudentProfileDao {

	@Autowired
	private StudentProfileRepository profileRepository;
	
	@Override
	public void createStudentProfile(StudentProfile studentProfile) {
		profileRepository.save(studentProfile);
	}

	@Override
	public StudentProfile getProfile(String username) {
		StudentProfile getProfile = profileRepository.findByUsername(username);
		if (getProfile.equals(null)) {
			System.out.println("This is null Object:");
		}
		return getProfile;
	}

}
