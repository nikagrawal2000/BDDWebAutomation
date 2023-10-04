package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	private static ReadConfig rc;
	private Properties pro;
	private String configFile = System.getProperty("user.dir") + File.separator + "automation.properties";

	public static ReadConfig getInstance() {
		if (rc == null) {
			rc = new ReadConfig();
		}
		System.out.println(rc.getBaseUrl());
		return rc;
	}

	private ReadConfig() {
		File src = new File(configFile);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("WebURL");
		return url;
	}

	public String getUsername() {
		String username = pro.getProperty("userName");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getBrowser() {
		String password = pro.getProperty("browser");
		return password;
	}

	public int getImplicitTimeout() {
		int timeout = Integer.parseInt(pro.getProperty("implicitTimeout"));
		return timeout;
	}

	public String getBaseUrl() {
		String baseUrl = pro.getProperty("baseUrl");
		return baseUrl;
	}

	public String getAppId() {
		String appId = pro.getProperty("appId");
		return appId;
	}

}
