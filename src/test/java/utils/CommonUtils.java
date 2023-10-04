package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CommonUtils {
	private static Logger logger;

	static {
		PropertyConfigurator.configure("log4j.properties");
	}

	public static Logger getWebLoggerInstance() {
		logger = Logger.getLogger("E-Commerce Test");
		return logger;
	}

	public static Logger getRestAPILoggerInstance() {
		logger = Logger.getLogger("PetStore Test");
		return logger;
	}

}
