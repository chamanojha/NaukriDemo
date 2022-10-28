package com.naukri.qa.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {
	public static Properties readProperties() {
		Properties prop = null ;
		try {
			
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
			prop.load(fis);
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}
