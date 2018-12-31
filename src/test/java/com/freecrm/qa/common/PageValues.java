package com.freecrm.qa.common;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class PageValues {
	private static Properties pageValues = new Properties();;
	static {
		String userHomeDir = FileUtils.getUserDirectory().getAbsolutePath();
		String path = userHomeDir + "/com/freecrm/qa/";
		String file = "pageValues.properties";
		// load properties from file system - user directory
		try {
			System.out.println("Loading " + file + " from path: " + path);
			FileInputStream ip = new FileInputStream(path + file);
			pageValues.load(ip);
		} catch (Exception e) {
			System.out.println("Unable to load " + file + " from path " + path+". Will search in classpath.");
			// if properties not externalized, load from classpath
			try {
				pageValues.load(Config.class.getClassLoader().getResourceAsStream(file));
			} catch (Exception e1) {
				System.out.println("Unable to find property file " + file + " in classpath");
				e1.printStackTrace();
			}
		}
	}

	public static String getProperty(String name) {
		return pageValues.getProperty(name);
	}
}
