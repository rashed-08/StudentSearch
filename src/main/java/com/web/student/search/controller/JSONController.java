package com.web.student.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.student.search.controller.serviceImpl.ControllerServiceImpl;
import com.web.student.search.dto.PromoCode;
import com.web.student.search.dto.Student;

@RestController
public class JSONController {
	
	@Autowired
	private  ControllerServiceImpl controllerService;
	
	@RequestMapping("/json/show/all")
	public List<Student> getAllStudents() {
		System.out.println("");
		List<Student> getAll = controllerService.jsonStudentList();
		return getAll;
	}
	
	@GetMapping("/list/promo/code")
	public List<PromoCode> getAllPromoCode() {
		List<PromoCode> getAllPromoCode = controllerService.getAllPromoCode();
		return getAllPromoCode;
	}
	
	@GetMapping("/json/active/student")
	public List<Student> getAllActivteStudent() {
		boolean activeStatus = true;
		List<Student> getAllActiveStudent = controllerService.activeStudentList(activeStatus);
		return getAllActiveStudent;
	}

	@GetMapping("/json/inactive/student")
	public List<Student> getAllInactivteStudent() {
		boolean activeStatus = false;
		List<Student> getAllActiveStudent = controllerService.suspendStudentList(activeStatus);
		return getAllActiveStudent;
	}

	@GetMapping("/json/student/department")
	public List<Student> getStudentWithDepartment() {
		List<Student> getStudentAndDepartment = controllerService.getStudentWithDepartment();
		System.out.println("The size: " + getStudentAndDepartment.size());
		return getStudentAndDepartment;
	}
}
