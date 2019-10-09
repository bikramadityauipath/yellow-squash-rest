package com.yellow.squash.rest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AppUtil {

//	Payment Gateway Properties
	
	public static final String DEFAULT_DATE_FORMAT = "dd MMMM yyyy";
	
	static SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT);  
	
	public static String getRandomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return "111";
//        return salt.toString();
    }

	public static Date getDateAndTime(int addDays) {
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.HOUR_OF_DAY, 10);	// CDT to IST uncomment in production
//		cal.add(Calendar.MINUTE, 30);	// CDT to IST uncomment in production
		cal.add(Calendar.DAY_OF_MONTH, addDays);
		return cal.getTime();
	}
	
	public static String dateToString(Date javaDate) {
		return formatter.format(javaDate);
	}
	
	public static Date StringToDate(String stringDate) throws ParseException {
		return formatter.parse(stringDate);
	}
}
