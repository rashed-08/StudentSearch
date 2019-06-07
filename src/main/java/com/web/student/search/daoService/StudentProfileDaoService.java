package com.web.student.search.daoService;

import com.web.student.search.dto.StudentProfile;

public interface StudentProfileDaoService {
	
	void createStudentProfile(StudentProfile studentProfile);
	StudentProfile getProfile(String username);

}
