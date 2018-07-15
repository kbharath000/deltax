package com.deltax.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public   class ReadProperties {
	public Properties readProperties() {
		Properties prop = new Properties();
		try {
			File f = new File(System.getProperty("user.dir") + "/deltax.properties");
			FileInputStream fi = new FileInputStream(f);
			prop.load(fi);
			fi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}


}
