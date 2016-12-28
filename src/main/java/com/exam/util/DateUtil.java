package com.exam.util;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**时间工具类
 * @author HR-LZ
 *
 */
public class DateUtil {
	
	private DateUtil(){}
	
	/**获取指定格式的日期字符串
	 * @param date 日期
	 * @param pattern 格式化方式
	 * @return
	 */
	public static String format(Date date,String pattern) {  
        try {  
            return DateFormatUtils.format(date, pattern);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
}
