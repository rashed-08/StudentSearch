package com.web.student.search.controller.serviceImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.student.search.controller.service.ControllerService;
import com.web.student.search.daoServiceImpl.DepartmentDaoServiceImpl;
import com.web.student.search.daoServiceImpl.PromoCodeDaoServiceImpl;
import com.web.student.search.daoServiceImpl.StudentDaoServiceImpl;
import com.web.student.search.daoServiceImpl.StudentProfileDaoServiceImpl;
import com.web.student.search.dto.Authority;
import com.web.student.search.dto.Department;
import com.web.student.search.dto.PromoCode;
import com.web.student.search.dto.Student;
import com.web.student.search.dto.StudentProfile;
import com.web.student.search.report.serviceImpl.ReportGeneratorServiceImpl;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ControllerServiceImpl implements ControllerService {

	@Autowired
	private StudentDaoServiceImpl studentDaoService;

	@Autowired
	private StudentProfileDaoServiceImpl profileService;

	@Autowired
	private DepartmentDaoServiceImpl deptDaoService;

	@Autowired
	private PromoCodeDaoServiceImpl promoCodeService;

	@Autowired
	private ReportGeneratorServiceImpl reportService;

	@Autowired
	private PasswordEncoder encoder;

	private String viewPage = "";

	@Override
	public String createStudent(Student student) {

		String getPromoCode = student.getPromoCode();

		String fetchPromoCode = getPromoCode(getPromoCode);

		if (student.getPromoCode().equals(fetchPromoCode)) {
			String newUser = student.getUsername();
			Student existingUser = null;
			try {
				existingUser = fetchStudent(newUser);
				if (existingUser == null) {
					String studentPassword = student.getPassword();
					String encodedPassword = encoder.encode(studentPassword);
					student.setPassword(encodedPassword);
					student.setEnabled(true);
					Authority authorities = new Authority();
					authorities.setRole("ROLE_USER");
					authorities.setUsername(student.getUsername());
					student.setAuthorities(authorities);
					studentDaoService.createOrUpdateStudent(student);
					viewPage = "redirect:/login?=register";
				}

				else {
					viewPage = "exist";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			viewPage = "register";
		}
		return viewPage;
	}

	private String getPromoCode(String getPromoCode) {
		PromoCode getPromoCodeName = promoCodeService.getPromoCode(getPromoCode);
		String promoCodeName = getPromoCodeName.getPromoCodeName();
		return promoCodeName;
	}

	@Override
	public List<Student> getStudent() {
		List<Student> getStudentList = new ArrayList<>();
		getStudentList = studentDaoService.getAllStudent();
		return getStudentList;
	}

	@Override
	public String createStudentProfile(StudentProfile studentProfile) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String getLogedUsername = auth.getName();
		Student getStudent = fetchStudent(getLogedUsername);
		studentProfile.setUsername(getStudent.getUsername());
		getStudent.setProfile(studentProfile);
		profileService.createStudentProfile(studentProfile);
		viewPage = "redirect:/home";
		return viewPage;
	}

	@Override
	public StudentProfile editStudentProfile(String logedUser) {
		StudentProfile getProfile = profileService.getProfile(logedUser);
		return getProfile;
	}

	@Override
	public List<Department> getAllDepartment() {
		List<Department> getAllDepartment = deptDaoService.getAllDepartment();
		return getAllDepartment;
	}

	@Override
	public String createAdmin(Student student) {
		Student existingUser = null;
		if (student.getPromoCode().equals("admin")) {
			String newUser = student.getUsername();
			try {
				existingUser = fetchStudent(newUser);
				if (existingUser == null) {
					String studentPassword = student.getPassword();
					String encodedPassword = encoder.encode(studentPassword);
					student.setPassword(encodedPassword);
					student.setEnabled(true);
					Authority authorities = new Authority();
					authorities.setRole("ROLE_ADMIN");
					authorities.setUsername(student.getUsername());
					student.setAuthorities(authorities);
					studentDaoService.createOrUpdateStudent(student);
					viewPage = "redirect:/login?=register";
					System.out.println("Controller service, test:1 " + viewPage);
				} else {
					viewPage = "admin-register";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			viewPage = "admin-register";
		}
		return viewPage;
	}

	@Override
	public String addDepartment(Department department) {
		deptDaoService.createDepartment(department);
		viewPage = "redirect:/students";
		return viewPage;
	}

	@Override
	public Student fetchStudent(String username) {
		Student getSingleStudent = studentDaoService.getStudent(username);
		return getSingleStudent;
	}

	@Override
	public String updateStudent(Student student) {
		studentDaoService.createOrUpdateStudent(student);
		return "You hava successully updated this student!";
	}

	@Override
	public void updatePromoCode(PromoCode promoCode) {
		promoCodeService.createPromoCode(promoCode);
	}

	@Override
	public List<Student> jsonStudentList() {
		List<Student> getAll = new ArrayList<>();
		getAll = studentDaoService.getAllStudent();
		List<Student> allStudent = new ArrayList<>();
		for (Student student : getAll) {
			if (student.getAuthorities().getRole().contains("ADMIN")) {
				continue;
			} else {
				allStudent.add(student);
			}
		}
		return allStudent;
	}

	@Override
	public List<PromoCode> getAllPromoCode() {
		List<PromoCode> getAllPromoCode = promoCodeService.getAllPromoCode();
		return getAllPromoCode;
	}

	@Override
	public List<Student> activeStudentList(boolean flag) {
		List<Student> getActiveStudentList = studentDaoService.getActiveStudent(flag);
		List<Student> allActiveStudent = new ArrayList<>();
		for (Student student : getActiveStudentList) {
			if (student.getAuthorities().getRole().contains("ADMIN")) {
				continue;
			} else {
				allActiveStudent.add(student);
			}
		}
		return allActiveStudent;
	}

	@Override
	public void suspendStudent(String username) {
		Student getStudent = fetchStudent(username);
		boolean inactiveStatus = false;
		getStudent.setEnabled(inactiveStatus);
		studentDaoService.createOrUpdateStudent(getStudent);
	}

	@Override
	public List<Student> suspendStudentList(boolean flag) {
		List<Student> getSuspendStudentList = studentDaoService.getInactiveStudent(flag);
		return getSuspendStudentList;
	}

	@Override
	public void activateStudent(String username) {
		Student getStudent = fetchStudent(username);
		boolean inactiveStatus = true;
		getStudent.setEnabled(inactiveStatus);
		studentDaoService.createOrUpdateStudent(getStudent);
	}

	@Override
	public List<Student> getStudentWithDepartment() {
		List<Student> getStudentWithDepartment = studentDaoService.getAllStudentWithDepartment();
		return getStudentWithDepartment;
	}

	@Override
	public StudentProfile fetchStudentProfile(String username) {
		StudentProfile fetchStudentProfile = profileService.getProfile(username);
		return fetchStudentProfile;
	}

	@Override
	public void studentReport(HttpServletResponse response) throws JRException, IOException, SQLException {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String stringDate = formatter.format(date);
		System.out.println("The date: " + stringDate);
		JasperPrint jasperPrint = null;
		response.setContentType("application/x-download");
		response.setHeader("Content-Description", String.format("attachment; filename=" + stringDate + ".pdf"));
		OutputStream out = response.getOutputStream();
		jasperPrint = reportService.exportStudentPdf();
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
		out.flush();
		out.close();
	}

	@Override
	public void exportStudentProfilePdf(HttpServletResponse response) throws JRException, SQLException, IOException {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String stringDate = formatter.format(date);
		String fileName = stringDate + "_student_with_profile.pdf";
		JasperPrint jasperPrint = null;
		response.setContentType("application/x-download");
		response.setHeader("Content-Description", String.format("attachment; filename=" + fileName));
		OutputStream out = response.getOutputStream();
		jasperPrint = reportService.exportStudentProfilePdf();
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
		out.flush();
		out.close();

	}

}
