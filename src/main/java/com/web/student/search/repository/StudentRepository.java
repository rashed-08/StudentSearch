package com.web.student.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.student.search.dto.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

	/*@Query("SELECT s.username, p.departmentName from Student s INNER JOIN StudentProfile p on s.username=p.username")
	List<Student> fetchStudentInnerJoin();*/
	
	public Student findByUsername(String username);
	@Query(value = "SELECT DISTINCT * FROM student WHERE enabled=true", nativeQuery=true)
	public List<Student> findByEnabled(boolean flag);
	@Query(value = "SELECT DISTINCT * FROM student WHERE enabled=false", nativeQuery=true)
	public List<Student> findInactiveStudent(boolean flag);
	@Query(value = "select s.username, s.first_name, s.last_name, s.email, p.department_name from student as s inner join student_profile as p on s.authorities_username=p.username group by s.username", nativeQuery=true)
	public List<Student> findStudentWithDepartment();
	
}
