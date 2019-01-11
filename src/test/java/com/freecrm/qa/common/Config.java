package com.freecrm.qa.common;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Config {
	private static Logger log = LogManager.getLogger(Config.class.getName());
	private static Properties config = new Properties();;
	static {
		String userHomeDir = FileUtils.getUserDirectory().getAbsolutePath();
		String path = userHomeDir + "/com/freecrm/qa/";
		String file = "config.properties";
		// load properties from file system - user directory
		try {
			log.info("Loading " + file + " from path:" + path);
			FileInputStream ip = new FileInputStream(path + file);
			config.load(ip);
		} catch (Exception e) {
			log.info("Unable to load property file " + file + " from path " + path);
			// if properties not externalized, load from classpath
			try {
				config.load(Config.class.getClassLoader().getResourceAsStream(file));
			} catch (Exception e1) {
				log.info("Unable to find property file " + file + " in classpath");
				e1.printStackTrace();
			}
		}
	}

	public static String getProperty(String name) {
		return config.getProperty(name);
	}
}
