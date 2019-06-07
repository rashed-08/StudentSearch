package com.web.student.search.os.factory;

public class OSFactory {
	private static OSFactory object;

	private OSFactory() {
		// TODO Auto-generated constructor stub
	}

	public static OSFactory getInstance() {
		if (object == null) {
			synchronized (OSFactory.class) {
				if (object == null) {
					object = new OSFactory();
				}
			}
		}
		return object;
	}

	public OperatingSystem getOS(String os) {
		if (os == null) {
			return null;
		}

		if (os.equalsIgnoreCase("linux")) {
			return new LinuxOS();
		} else if (os.equalsIgnoreCase("windows")) {
			return new WindowsOS();
		} else if (os.equalsIgnoreCase("mac")) {
			return new MacOS();
		}
		return null;
	}
}
