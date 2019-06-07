package com.web.student.search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentSearchApplicationTests {
	
	@Test
	public void Test() {
		
	}

/*	@Test
	public void check() {
		Authority auth = new Authority();
		auth.setRole("admin");
		Student stu = new Student();
		stu.setAuthorities(auth);
		System.out.println(stu.getAuthorities().getRole());
		assertEquals(stu.getAuthorities().getRole(), "admin");
	}
*/
}
