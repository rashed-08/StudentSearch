package com.web.student.search.controller.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.web.student.search.dto.Department;
import com.web.student.search.dto.PromoCode;
import com.web.student.search.dto.Student;
import com.web.student.search.dto.StudentProfile;

import net.sf.jasperreports.engine.JRException;

public interface ControllerService {
	
	public String createStudent(Student student);
	public List<Student> getStudent();
	public String createStudentProfile(StudentProfile studentProfile);
	public StudentProfile editStudentProfile(String logedUser);
	public List<Department> getAllDepartment();
	public String createAdmin(Student student);
	public String addDepartment(Department department);
	public Student fetchStudent(String username);
	public String updateStudent(Student student);
	public void updatePromoCode(PromoCode promoCode);
	public List<Student> jsonStudentList();
	public List<PromoCode> getAllPromoCode();
	public List<Student> activeStudentList(boolean flag);
	public void suspendStudent(String username);
	public List<Student> suspendStudentList(boolean flag);
	public void activateStudent(String username);
	public List<Student> getStudentWithDepartment();
	public StudentProfile fetchStudentProfile(String username);
	public void studentReport(HttpServletResponse response) throws JRException, IOException, SQLException;
	public void exportStudentProfilePdf(HttpServletResponse response) throws JRException, IOException, SQLException;
}
