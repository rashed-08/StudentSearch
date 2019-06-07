package com.web.student.search;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.web.student.search.controller.JSONController;
import com.web.student.search.controller.serviceImpl.ControllerServiceImpl;
import com.web.student.search.daoServiceImpl.StudentDaoServiceImpl;
import com.web.student.search.dto.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySource("classpath:test_application.properties")
public class StudentTest {

	@Autowired
	private JSONController studentDaoServiceImpl;

	/*
	 * @Test public void saveMethod() { Student test_studnt = new Student();
	 * test_studnt.setFirstName("Nayeem"); test_studnt.setLastName("Siddique");
	 * test_studnt.setUsername("username"); test_studnt.setEmail("user@email.com");
	 * test_studnt.setPassword("user_pass"); test_studnt.setPromoCode("use");
	 * 
	 * studentDaoServiceImpl.createStudent(test_studnt); }
	 * 
	 * 
	 */

/*	@Test
	public void OSBasedDirectory() {
		
		String osName = System.getProperty("os.name");
		OSFactory osFactory = OSFactory.getInstance();
		OperatingSystem operatingSystem = osFactory.createPath(osName);
		operatingSystem.createPath();
		osFactory.createPath(osName);
		
	}*/

	// @Test
	// public void createDirectory() {
	// String username = System.getProperty("user.dir");
	// System.out.println(username);
	// File folder = new File(username + File.separator + "StudentSearch");
	// if (folder.exists() && folder.isDirectory()) {
	// System.out.println("Already folder created!");
	// } else {
	// folder.mkdir();
	// System.out.println("New folder created!");
	// }
	// }
	
	
/*	@Test
	public void getStudentList() {
		List<Student> getStudents = new ArrayList<>();
		getStudents = studentDaoServiceImpl.getAllStudent();
		assertEquals(getStudents.size(), 1);
	}
*/	
	@Test
	public void testStudent() {
		List<Student> getAll = studentDaoServiceImpl.getAllStudents();
		
		assertEquals(1, getAll.size());
	}
}
