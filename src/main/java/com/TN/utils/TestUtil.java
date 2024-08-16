package com.TN.utils;

import java.util.Date;

public class TestUtil {

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGELOAD_TIME_WAIT = 10;
	public static final int SCRIPT_TIME_WAIT = 10;
	
	
	
	public static String emailWithDateTimeStampAction() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "rae.rom" + timeStamp + "@gmail.com";
	}
}