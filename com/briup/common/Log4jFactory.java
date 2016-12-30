package com.briup.common;

import org.apache.log4j.Logger;

public class Log4jFactory {
	private static Logger logger;

	public static Logger getLogger(){
		logger=Logger.getLogger("log4j.properties");
		return logger;
	}
}
