package com.tutorialsNinja.utils;

import java.util.Date;

public class Utilities {
	
	
	public static String Emailgenerator() {
		Date date=new Date();
		String timstampString=date.toString().replaceAll(" ", "_").replace(":", "_");
		return "sai"+timstampString+"@gamil.com";

	}

}
