/**
 * 
 */
package com.cognizant.moviecruiser.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ created by madhangi 761100
 *
 */
public class DateUtil {

	
	public static Date convertToDate(String date)throws ParseException
	{
		
		
		 return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}
	
	
	
}
