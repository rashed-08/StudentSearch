package com.web.student.search.dao;

import com.web.student.search.dto.StudentProfile;

public interface StudentProfileDao {
	
	void createStudentProfile(StudentProfile studentProfile);
	StudentProfile getProfile(String username);

}
