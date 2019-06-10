package com.web.student.search.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.student.search.controller.serviceImpl.ControllerServiceImpl;
import com.web.student.search.dto.Department;
import com.web.student.search.dto.PromoCode;
import com.web.student.search.dto.Student;
import com.web.student.search.dto.StudentProfile;

import net.sf.jasperreports.engine.JRException;

@Controller
public class MainController {

	@Autowired
	private ControllerServiceImpl controllerService;

	private String viewPage = "";

	@RequestMapping(value = { "/", "/index", "/home" })
	public String showHome() {
		viewPage = "home";
		return viewPage;
	}

	@RequestMapping(value = "/about")
	public String showAbout() {
		viewPage = "about";
		return viewPage;
	}

	@RequestMapping(value = "/login")
	public String showLogin(@RequestParam(value = "register", required = false) String registerFlag, Model model) {
		if (registerFlag != null) {
			model.addAttribute("register", registerFlag);
		}
		viewPage = "login";
		return viewPage;
	}

	@RequestMapping(value = "/register")
	public String showRegister(Model model) {
		model.addAttribute("student", new Student());
		viewPage = "register";
		return viewPage;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String submitStudent(@ModelAttribute @Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			viewPage = "register";
			return viewPage;
		}
		viewPage = controllerService.createStudent(student);
		if (viewPage.equals("register")) {
			model.addAttribute("promo", "Please provide promo code or contact Student Affair");
			viewPage = "register";
		} else if (viewPage.equals("exist")) {
			model.addAttribute("exist", "Username already exist");
			viewPage = "register";
		} else if (viewPage.equals("redirect:/login?=register")) {
			viewPage = "redirect:/login?=register";
		}
		return viewPage;
	}

	@RequestMapping("/student/show")
	public String studentShow(Model model) {
		List<Student> getStudentList = controllerService.getStudent();
		model.addAttribute("students", getStudentList);
		viewPage = "all_students";
		return viewPage;
	}

	@RequestMapping("/edit/profile")
	public String showStudentProfile(Model model) {
		String formObject = "studentProfile";
		model.addAttribute(formObject, new StudentProfile());
		viewPage = "edit-student-profile";
		return viewPage;
	}

	@PostMapping("/edit/profile")
	public String submitStudentProfile(@ModelAttribute StudentProfile studentProfile, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			viewPage = "edit-student-profile";
			return viewPage;
		}
		viewPage = controllerService.createStudentProfile(studentProfile);
		System.out.println("The viewPage: " + viewPage);
		if (viewPage.equals("profile")) {
			model.addAttribute("message", "Please provide valid input");
			viewPage = "edit-student-profile";
			return viewPage;
		}
		return viewPage;
	}

	@GetMapping("/profile")
	public String editStudentProfile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String getLogedUsername = auth.getName();
		try {
			StudentProfile getProfile = controllerService.editStudentProfile(getLogedUsername);
			if (getProfile != null) {
				model.addAttribute("user", getProfile);
			} else {
				model.addAttribute("user", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		viewPage = "profile";
		return viewPage;
	}

	@GetMapping("/students")
	public String showAllStudent(Model model) {
		viewPage = "all-student";
		return viewPage;
	}

	@ModelAttribute("all_dept")
	public List<Department> getAllDepartment() {
		List<Department> getAllDepartment = controllerService.getAllDepartment();
		return getAllDepartment;
	}

	// admin register
	@GetMapping(value = "/auth/user/admin/register")
	public String showAdminForm(Model model) {
		model.addAttribute("student", new Student());
		viewPage = "admin-register";
		return viewPage;
	}

	@PostMapping("/auth/user/admin/register")
	public String submitAdminForm(@ModelAttribute @Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			viewPage = "admin-register";
			return viewPage;
		}
		viewPage = controllerService.createAdmin(student);
		System.out.println("The view page: " + viewPage);
		if (viewPage.equals("admin-register")) {
			model.addAttribute("promo", "Please contact with adminstrator");
			viewPage = "admin-register";
			return viewPage;
		}
		return viewPage;
	}

	@GetMapping("/add/department")
	public String addDepartment(Model model) {
		model.addAttribute("department", new Department());
		viewPage = "add-department";
		return viewPage;
	}

	@PostMapping("/add/department")
	public String addDepartment(@ModelAttribute @Valid Department department, BindingResult result, Model model) {
		if (result.hasErrors()) {
			viewPage = "add-department";
			return viewPage;
		}
		viewPage = controllerService.addDepartment(department);
		return viewPage;
	}

	@GetMapping("/update/student/{username}")
	public String updateStudent(@PathVariable String username, Model model) {
		Student getSingleStudent = controllerService.fetchStudent(username);
		if (getSingleStudent != null) {
			model.addAttribute("student", getSingleStudent);
		}
		viewPage = "update-student";
		return viewPage;
	}

	@PostMapping("/update/student")
	public String submitUpdateStudent(@ModelAttribute @Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			viewPage = "update-student";
			return viewPage;
		}
		String status = controllerService.updateStudent(student);
		model.addAttribute("updated", status);
		viewPage = "update-student";
		return viewPage;
	}

	@GetMapping("/update/promo-code")
	public String addPromoCode(Model model) {
		model.addAttribute("promoCode", new PromoCode());
		viewPage = "update-promo-code";
		return viewPage;
	}

	@PostMapping("/update/promo-code")
	public String addPromoCode(@ModelAttribute @Valid PromoCode promoCode, BindingResult result, Model model) {
		if (result.hasErrors()) {
			viewPage = "update-promo-code";
			return viewPage;
		}
		controllerService.updatePromoCode(promoCode);
		viewPage = "redirect:/list/promo-code";
		return viewPage;
	}

	@GetMapping("/list/promo-code")
	public String listPromoCode(Model model) {
		viewPage = "list-promo-code";
		return viewPage;
	}

	@GetMapping("/show/running/student")
	public String showRunningStudent() {
		viewPage = "running-student";
		return viewPage;
	}

	@GetMapping("/suspend/student/{username}")
	public String suspendStudent(@PathVariable String username) {
		controllerService.suspendStudent(username);
		viewPage = "redirect:/show/running/student";
		return viewPage;
	}

	@GetMapping("/show/suspend/student")
	public String showSuspendedStudent() {
		viewPage = "suspend-student";
		return viewPage;
	}

	@GetMapping("/activate/student/{username}")
	public String ActivateStudent(@PathVariable String username) {
		controllerService.activateStudent(username);
		viewPage = "redirect:/show/suspend/student";
		return viewPage;
	}

	@GetMapping("/show/profile/{username}")
	public String showStudent(@PathVariable String username, Model model) {
		try {
			StudentProfile profile = controllerService.fetchStudentProfile(username);
			if (profile != null) {
				model.addAttribute("profile", profile);
			} else {
				model.addAttribute("profile", "");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		viewPage = "show-profile";
		return viewPage;
	}

	@RequestMapping("/reset/password")
	public String resetPassword() {
		System.out.println("Controller is working...");
		viewPage = "reset";
		return viewPage;
	}
	
/*	@PostMapping("/rest/password")
	public String submitResetPassword() {
		return "redirect:/login";
	}
*/
	@GetMapping("/export")
	public String exportStudentPdf(HttpServletResponse response) throws JRException, IOException, SQLException {
		controllerService.studentReport(response);
		viewPage = "all-student";
		return viewPage;
	}

	@GetMapping("/export/with-profile")
	public String exportStudentProfilePdf(HttpServletResponse response) throws JRException, IOException, SQLException {
		controllerService.exportStudentProfilePdf(response);
		viewPage = "all-student";
		return viewPage;
	}

}
