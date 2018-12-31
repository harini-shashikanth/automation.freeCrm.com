package com.freecrm.qa.common;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class Config {
	private static Properties config = new Properties();;
	static {
		String userHomeDir = FileUtils.getUserDirectory().getAbsolutePath();
		String path = userHomeDir+ "/com/freecrm/qa/";
		String file = "config.properties";
		// load properties from file system - user directory
		try {
			System.out.println("Loading "+file+" from path:" + path);
			FileInputStream ip = new FileInputStream(path + file);
			config.load(ip);
		} catch (Exception e) {
			System.out.println("Unable to load property file " + file + " from path " + path);
			// if properties not externalized, load from classpath
			try {
				config.load(Config.class.getClassLoader().getResourceAsStream(file));
			} catch (Exception e1) {
				System.out.println("Unable to find property file " + file + " in classpath");
				e1.printStackTrace();
			}
		}
	}

	public static String getProperty(String name) {
		return config.getProperty(name);
	}
}
