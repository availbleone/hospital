package com.xiaotong.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 获得系统日期，默认格式yyyy-MM-dd
	 * @return
	 */
	public static String getSysDate(){
		return getSysDate("yyyy-MM-dd");
	}
	/**
	 * 获得系统时间，默认格式yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getSysTime(){
		return getSysDate("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 获得系统时间
	 * @param pattern 时间格式
	 * @return
	 */
	public static String getSysDate(String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
}
