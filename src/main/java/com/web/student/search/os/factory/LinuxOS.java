package com.web.student.search.os.factory;

import java.io.File;

public class LinuxOS implements OperatingSystem {

	@Override
	public void createDirectory() {
		String directory = System.getProperty("user.home");
		String createPath = directory + File.separator + "StudentSearch";
		File path = new File(createPath);
		if (!path.exists()) {
			path.mkdir();
		}
	}
}
