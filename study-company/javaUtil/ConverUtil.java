package com.classroom.utils;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConvertUtil {
	private static final Log log = LogFactory.getLog(ConvertUtil.class);
	public static final String YMD = "yyyy-MM-dd";
	public static final String YMD_HMS = "yyyy-MM-dd HH:mm:ss";
	
	public static Date toDate(String dateStr) {
		return toDate(dateStr, YMD);
	}

	public static Date toDate(String dateStr, String dateFormat) {
		if ((dateStr == null) || ("".equals(dateStr.trim()))) {
			return null;
		}
		SimpleDateFormat f = new SimpleDateFormat(dateFormat);
		try {
			return f.parse(dateStr);
		} catch (ParseException e) {
		}
		return null;
	}

	public static String toString(Date date) {
		return toString(date, YMD);
	}

	public static String toString(Date date, String dateFormat) {
		if (date == null) {
			return "";
		}
		if (dateFormat == null) {
			dateFormat = YMD;
		}

		SimpleDateFormat f = new SimpleDateFormat(dateFormat);
		return f.format(date);
	}

	public static Timestamp toTimestamp(String dateStr) {
		return toTimestamp(dateStr, YMD);
	}

	public static Timestamp toTimestamp(String dateStr, String format) {
		if ((dateStr == null) || (dateStr.trim().equals(""))) {
			return null;
		}
		if (format == null) {
			format = YMD;
		}
		if (log.isDebugEnabled()) {
			log.debug(":::[toTimestamp]format->" + format);
		}
		DateFormat sdf = new SimpleDateFormat(format);
		try {
			return new Timestamp(sdf.parse(dateStr).getTime());
		} catch (ParseException e) {
			if (log.isDebugEnabled()) {
				log.debug("Invalid date format ->[" + dateStr + "]");
			}
		}
		return null;
	}
}
