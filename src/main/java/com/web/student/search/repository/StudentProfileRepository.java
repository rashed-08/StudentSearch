package com.web.student.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.student.search.dto.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, String> {

	@Query(value = "select * from student_profile where student=:student", nativeQuery = true)
	StudentProfile findByUsername(@Param(value = "student") String student);
}
