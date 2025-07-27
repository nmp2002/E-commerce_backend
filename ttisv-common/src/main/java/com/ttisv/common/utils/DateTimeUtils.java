package com.ttisv.common.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Handx Tien ich convert date time
 * 
 */

public class DateTimeUtils {

	private static final Logger LOGGER = LogManager.getLogger(DateTimeUtils.class.getName());

	public static void getYear(Date from, Date to, int year, long day) {
		double yeargoc = (double) (DateTimeUtils.getDimdd(from, to)) / 365;

		year = (int) yeargoc;
		day = 0;
		if (yeargoc > year) {
			Date date = getDateaddMonths(from, year * 12);
			day = DateTimeUtils.getDimdd(date, to);
		}

	}

	public static String now() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(new Date());
	}

	public static String now(String f) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(f);
		return sdf.format(cal.getTime());
	}

	public static Date convertStringToDate(String s, String f) {
		Date d = new Date();
		try {
			SimpleDateFormat format = new SimpleDateFormat(f, Locale.getDefault());
			d = format.parse(s);
		} catch (Exception e) {
			e.printStackTrace();
//			LOGGER.error("DateTimeUtils.convertStringToDate()", e);
			return null;
		}
		return d;
	}

	public static Date beginDate(String s, String f) {
		Date d = new Date();
		try {
			SimpleDateFormat format = new SimpleDateFormat(f);
			d = format.parse(s + " 00:00:00");
		} catch (Exception e) {
			LOGGER.error("DateTimeUtils.beginDate()", e);
		}
		return d;
	}

	public static Date endDate(String s, String f) {
		Date d = new Date();
		try {
			SimpleDateFormat format = new SimpleDateFormat(f);
			d = format.parse(s + " 23:59:59");
		} catch (Exception e) {
			LOGGER.error("DateTimeUtils.endDate()", e);
		}
		return d;
	}

	/**
	 * 
	 * @param String dd/MM/yyyy
	 * @return yyyMMdd
	 */
	public static String ddMMyyyyTo(String s) {
		String sReturn = "";
		try {
			sReturn = s.substring(6, 10) + s.substring(3, 5) + s.substring(0, 2);

		} catch (Exception e) {
			LOGGER.error("DateTimeUtils.ddMMyyyyTo()", e);
		}
		return sReturn;
	}

	public static Timestamp convertStringToTimestamp(String s, String f) {
		Timestamp timeStampDate = null;
		try {
			if (org.apache.commons.lang.StringUtils.isBlank(s)) {
				return null;
			}
			SimpleDateFormat formatter = new SimpleDateFormat(f);
			Date date = formatter.parse(s);
			timeStampDate = new Timestamp(date.getTime());
		} catch (Exception e) {
			LOGGER.error("DateTimeUtils.convertStringToTimestamp()", e);
		}
		return timeStampDate;
	}

	public static Timestamp beginDateTimeStamp(String s, String f) {
		Timestamp timeStampDate = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat(f);
			Date date = format.parse(s + " 00:00:00");
			timeStampDate = new Timestamp(date.getTime());

		} catch (Exception e) {
			LOGGER.error("DateTimeUtils.beginDateTimeStamp()", e);
		}

		return timeStampDate;
	}

	public static Timestamp endDateTimeStamp(String s, String f) {
		Timestamp timeStampDate = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat(f);
			Date date = format.parse(s + " 23:59:59");
			timeStampDate = new Timestamp(date.getTime());

		} catch (Exception e) {
			LOGGER.error("DateTimeUtils.endDateTimeStamp()", e);
		}

		return timeStampDate;
	}

	public static String convertDateToString(Date date, String f) {
		String newDate = "";
		try {
			DateFormat dateFormat = new SimpleDateFormat(f);
			newDate = dateFormat.format(date);
		} catch (Exception ex) {
//			LOGGER.error("DateTimeUtils.convertDateToString()", ex);
			return StringUtils.EMPTY;
		}
		return newDate;
	}

	/**
	 * 
	 * @param value 1 - 12 => Thang 1 - 12, 13 - 16 => Quy I - IV, 17 => 6 Thang dau
	 *              nam, 18 => 6 Thang cuoi nam, 19 => Nam
	 * @param year  - nam bao cao
	 * @return
	 */
	public static Map<Integer, String> getReportDateBy(int value, int year) {
		Map<Integer, String> map = new HashMap<>();
		try {
			String beginDate = "";
			String endDate = "";

			switch (value) {
			case 1:
				beginDate = "01/01/" + year + " 00:00:00";
				endDate = "31/01/" + year + " 23:59:59";
				break;
			case 2:
				beginDate = "01/02/" + year + " 00:00:00";
				endDate = "28/02/" + year + " 23:59:59";
				if (year % 4 == 0)
					endDate = "29/02/" + year + " 23:59:59";
				break;
			case 3:
				beginDate = "01/03/" + year + " 00:00:00";
				endDate = "31/03/" + year + " 23:59:59";
				break;
			case 4:
				beginDate = "01/04/" + year + " 00:00:00";
				endDate = "30/04/" + year + " 23:59:59";
				break;
			case 5:
				beginDate = "01/05/" + year + " 00:00:00";
				endDate = "31/05/" + year + " 23:59:59";
				break;
			case 6:
				beginDate = "01/06/" + year + " 00:00:00";
				endDate = "30/06/" + year + " 23:59:59";
				break;
			case 7:
				beginDate = "01/07/" + year + " 00:00:00";
				endDate = "31/07/" + year + " 23:59:59";
				break;
			case 8:
				beginDate = "01/08/" + year + " 00:00:00";
				endDate = "31/08/" + year + " 23:59:59";
				break;
			case 9:
				beginDate = "01/09/" + year + " 00:00:00";
				endDate = "30/09/" + year + " 23:59:59";
				break;
			case 10:
				beginDate = "01/10/" + year + " 00:00:00";
				endDate = "31/10/" + year + " 23:59:59";
				break;
			case 11:
				beginDate = "01/11/" + year + " 00:00:00";
				endDate = "30/11/" + year + " 23:59:59";
				break;
			case 12:
				beginDate = "01/12/" + year + " 00:00:00";
				endDate = "31/12/" + year + " 23:59:59";
				break;
			case 13:
				beginDate = "01/01/" + year + " 00:00:00";
				endDate = "31/03/" + year + " 23:59:59";
				break;
			case 14:
				beginDate = "01/04/" + year + " 00:00:00";
				endDate = "30/06/" + year + " 23:59:59";
				break;
			case 15:
				beginDate = "01/07/" + year + " 00:00:00";
				endDate = "30/09/" + year + " 23:59:59";
				break;
			case 16:
				beginDate = "01/10/" + year + " 00:00:00";
				endDate = "31/12/" + year + " 23:59:59";
				break;
			case 17:
				beginDate = "01/01/" + year + " 00:00:00";
				endDate = "30/06/" + year + " 23:59:59";
				break;
			case 18:
				beginDate = "01/07/" + year + " 00:00:00";
				endDate = "31/12/" + year + " 23:59:59";
				break;
			case 19:
				beginDate = "01/01/" + year + " 00:00:00";
				endDate = "31/12/" + year + " 23:59:59";
				break;
			default:
				String dNow = now();
				beginDate = dNow + " 00:00:00";
				endDate = dNow + " 23:59:59";
				break;
			}

			map.put(1, beginDate);
			map.put(2, endDate);

		} catch (Exception e) {
			LOGGER.error("DateTimeUtils.endDateTimeStamp()", e);
		}

		return map;
	}

	public static Date concatDateTime(Date ccDate, Date ccTime) {
		SimpleDateFormat dfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat dfDate = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dfTime = new SimpleDateFormat("HHmmss");
		String dateStr = dfDate.format(ccDate);
		String timeStr = ccTime == null ? "000000" : dfTime.format(ccTime);
		try {
			return dfDateTime.parse(dateStr + timeStr);
		} catch (ParseException e) {
		}
		return null;
	}

	public static Date concatDateTime2(Date ccDate, String ccTime) {
		try {
			SimpleDateFormat dfDateTime;
			String dateStr;
			String timeStr = "";
			dfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
			SimpleDateFormat dfDate = new SimpleDateFormat("yyyyMMdd");
			dateStr = dfDate.format(ccDate);
			timeStr = (ccTime != null && !"".equals(ccTime)) ? ccTime : "000000";
			return dfDateTime.parse((new StringBuilder(String.valueOf(dateStr))).append(timeStr).toString());
		} catch (ParseException e) {
			return null;
		}
	}

	public static boolean sameDay(Date oneDate, Date anotherDate) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(oneDate);
		int oneYear = gc.get(1);
		int oneMonth = gc.get(2);
		int oneDay = gc.get(5);
		gc.clear();
		gc.setTime(anotherDate);
		int anotherYear = gc.get(1);
		int anotherMonth = gc.get(2);
		int anotherDay = gc.get(5);
		if ((oneYear == anotherYear) && (oneMonth == anotherMonth) && (oneDay == anotherDay)) {
			return true;
		}
		return false;
	}

	public static boolean sameWeek(Date oneDate, Date anotherDate) {
		if (sameDay(oneDate, anotherDate)) {
			return true;
		}
		Date firstTime = null;
		Date secondTime = null;
		if (oneDate.after(anotherDate)) {
			firstTime = anotherDate;
			secondTime = oneDate;
		} else {
			firstTime = oneDate;
			secondTime = anotherDate;
		}
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(firstTime);
		gc.add(3, 1);
		Date tempTime = gc.getTime();
		if (!tempTime.after(secondTime)) {
			return false;
		}
		gc.clear();
		gc.setTime(firstTime);
		int firstWeekDay = gc.get(7);
		gc.clear();
		gc.setTime(secondTime);
		int secondWeekDay = gc.get(7);
		if (firstWeekDay < secondWeekDay) {
			return true;
		}
		return false;
	}

	public static boolean sameMonth(Date oneDate, Date anotherDate) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(oneDate);
		int oneYear = gc.get(1);
		int oneMonth = gc.get(2);
		gc.clear();
		gc.setTime(anotherDate);
		int anotherYear = gc.get(1);
		int anotherMonth = gc.get(2);
		if ((oneYear == anotherYear) && (oneMonth == anotherMonth)) {
			return true;
		}
		return false;
	}

	public static Date getDate(String str) {
		if ((str == null) || ("".equals(str))) {
			return null;
		}
		int date = Integer.parseInt(str.substring(0, 2));
		int month = Integer.parseInt(str.substring(3, 5)) - 1;
		int year = Integer.parseInt(str.substring(6, 10));
		Calendar newDate = Calendar.getInstance();
		newDate.set(year, month, date);
		return newDate.getTime();
	}

	public static Date getNextYearDate(String str) {
		if ((str == null) || ("".equals(str))) {
			return null;
		}
		int day = Integer.parseInt(str.substring(0, 2));
		int month = Integer.parseInt(str.substring(3, 5)) - 1;
		int year = Integer.parseInt(str.substring(6, 10));
		Calendar newDate = Calendar.getInstance();
		newDate.set(year + 1, month, day);
		newDate.set(Calendar.HOUR_OF_DAY, 23);
		newDate.set(Calendar.MINUTE, 59);
		newDate.set(Calendar.SECOND, 59);
		newDate.set(Calendar.MILLISECOND, 0);
		return newDate.getTime();
	}

	public String getFixPatternDate(Timestamp timestamp, int type) {
		if (timestamp == null) {
			return null;
		}
		SimpleDateFormat sdf = null;
		if (type == 1) {
			sdf = new SimpleDateFormat("yyyyMMdd");
		} else if (type == 2) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if (type == 3) {
			sdf = new SimpleDateFormat("dd/MM/yyyy");
		} else {
			return null;
		}
		Date date = new Date(timestamp.getTime());
		String formateDate = sdf.format(date);
		return formateDate;
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

	public static Date addMinutes(Date date, int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	public static String getFixPatternDate2(Date date, int type) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = null;
		if (type == 1)
			sdf = new SimpleDateFormat("yyyyMMdd");
		else if (type == 2)
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		else if (type == 3)
			sdf = new SimpleDateFormat("dd/MM/yyyy");
		else
			return null;
		String formateDate = sdf.format(date);
		return formateDate;
	}

	public static String getCurrentDate(int type) {
		SimpleDateFormat sdf = null;
		if (type == 1) {
			sdf = new SimpleDateFormat("yyyyMMdd");
		} else if (type == 2) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if (type == 3) {
			sdf = new SimpleDateFormat("dd/MM/yyyy");
		} else {
			return null;
		}
		Date date = new Date(System.currentTimeMillis());
		String formateDate = sdf.format(date);
		return formateDate;
	}

	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String formateDate = sdf.format(date);
		return formateDate.substring(9, 17);
	}

	public static String convertDateToString(Calendar d, String format) {
		String dd = Integer.toString(d.get(Calendar.DATE));
		String mm = Integer.toString(d.get(Calendar.MONTH) + 1);
		String yyyy = Integer.toString(d.get(Calendar.YEAR));
		String hh = Integer.toString(d.get(Calendar.HOUR_OF_DAY));
		String mi = Integer.toString(d.get(Calendar.MINUTE));
		String ss = Integer.toString(d.get(Calendar.SECOND));
		String ms = Integer.toString(d.get(Calendar.MILLISECOND));

		if (dd.length() == 1) {
			dd = "0" + dd;
		}
		if (mm.length() == 1) {
			mm = "0" + mm;
		}
		if (hh.length() == 1) {
			hh = "0" + hh;
		}
		if (mi.length() == 1) {
			mi = "0" + mi;
		}
		if (ss.length() == 1) {
			ss = "0" + ss;
		}
		if (ms.length() == 1) {
			ms = "0" + ms;
		}
		if ("DD".equalsIgnoreCase(format)) {
			return dd;
		} else if ("MM".equalsIgnoreCase(format)) {
			return mm;
		} else if ("YYYY".equalsIgnoreCase(format)) {
			return yyyy;
		} else if ("MM/YYYY".equals(format)) {
			return mm + "/" + yyyy;
		} else if ("DD/MM/YYYY".equals(format)) {
			return dd + "/" + mm + "/" + yyyy;
		} else if ("DD/MM/YYYY HH:MI:SS".equals(format)) {
			return dd + "/" + mm + "/" + yyyy + " " + hh + ":" + mi + ":" + ss;
		} else if ("DDMMYYYYHH24MISS".equals(format)) {
			return dd + mm + yyyy + hh + mi + ss;
		} else if ("DDMMYYYYHH24MISSMS".equals(format)) {
			return dd + mm + yyyy + hh + mi + ss + ms;
		} else if ("DDMMYYYY".equals(format)) {
			return dd + mm + yyyy;
		} else if ("yyyymmdd".equals(format)) {
			return yyyy + mm + dd;
		} else if ("yyyyMMdd".equals(format)) {
			return yyyy + mm + dd;
		} else if ("MMYYYY".equals(format)) {
			return mm + yyyy;
		} else if ("DD-MMM-YYYY HH:MI:SS".equals(format)) {
			SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			return format2.format(d.getTime());
		} else if ("YYYYMMDDHH24MISSMS".equals(format)) {
			return yyyy + mm + dd + hh + mi + ss + ms;
		} else if ("yyyyMMddhh24miss".equals(format)) {
			return yyyy + mm + dd + hh + mi + ss;
		} else if ("yyyyDDDHHmmss".equals(format)) {
			SimpleDateFormat format2 = new SimpleDateFormat(format);
			return format2.format(d.getTime());
		}
		return null;
	}

	public static String getCurrentDateTime() {
		return getCurrentDateTime("dd/MM/yyyy HH:mm:ss");
	}

	public static String getCurrentDateTime(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}

	public static long getDimdd(Date oneDate, Date anotherDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date _oneDate = oneDate;
		Date _anotherDate = anotherDate;
		try {
			_oneDate = sdf.parse(sdf.format(oneDate));
			_anotherDate = sdf.parse(sdf.format(anotherDate));
		} catch (ParseException localParseException) {
		}
		long dimdd = (_anotherDate.getTime() - _oneDate.getTime()) / 86400000L;
		return dimdd;
	}

	public static Date getDate(Date oneDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date _oneDate = oneDate;
		try {
			_oneDate = sdf.parse(sdf.format(oneDate));
		} catch (ParseException localParseException) {
		}
		return _oneDate;
	}

	public static long getDimdd2(Date oneDate, Date anotherDate) {

		long dimdd = (anotherDate.getTime() - oneDate.getTime());
		return dimdd;
	}

	public static Date getDateMonthsAgo(int numOfMonthsAgo) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -1 * numOfMonthsAgo);
		return c.getTime();
	}

	public static Date getDateaddMonths(Date date, int numOfMonths) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, numOfMonths);
		return c.getTime();
	}

	public static Date getDateDaysAgo(int numOfDaysAgo) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_YEAR, -1 * numOfDaysAgo);
		return c.getTime();
	}

	public static void main(String[] args) {
		try {

//			System.out.println(convertDateToString(new Date(), "HHmmss"));
			// System.out.println("sssssss:" +
			// DateTimeUtils.getCurrentDate("yyyyMMddHHmmssSSS"));
//			System.out.println("sssssss:" + now());
			String dat = convertDateToString(new Date(), PATTERN.yyyyMMddHHmmss.getValue());

			// System.out.println("sssssss:" +
			// DateTimeUtils.getCurrentDateTime(PATTERN.yyyyMMddHHmmss.getValue()));
			Date date = convertToDate("20240913", "yyyyMMdd");
			Date date1 = convertToDate("20230913", "yyyyMMdd");
			int year = 0;
			long day = 0;
			getYear(date1, date, year, day);
			System.out.println("------------:" + year + ";" + day);

			int aa = compareTwoDate(date1, date);
			System.out.println("------------:" + aa);
			String dt = DateTimeUtils.getCurrentDateTime("YY");
			System.out.println("sssssss33333333 :" + dt);
			BigDecimal dda = NumberUtils.getDecimal(1122 + "");
			double z = (double) 5 / 12;// (double) getDimdd(date,date1)/36;
			System.out.println("sssssss33333333 :" + z);

			getDimdd(date, date1);
			System.out.println("sssssss111111 :" + getDimdd(date, date1));
			Date ss = DateTimeUtils.convertStringToDate("20221010190342", DateTimeUtils.PATTERN.YYYYMMDD.getValue());
			System.out.println("sssssss:" + ss);

			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			String requesttime = now.format(formatter);

			String trxdate = DateTimeUtils.convertDateToString(new Date(), PATTERN.YYYYMMDD.getValue());
			System.out.println("sssssss:" + trxdate);

			/*
			 * Date nowTime = new Date(System.currentTimeMillis()); SimpleDateFormat sdf =
			 * new SimpleDateFormat("yyyy-MM-dd"); Date toTime = sdf.parse("2011-07-31");
			 * 
			 * long days = getDimdd(nowTime, toTime);
			 * System.out.println("sssssss:"+nowTime.getYear()); System.out.println(days);
			 */
			String dateString = getDateString("05042016", "ddMMyyyy", "dd/MM/yyyy");
			// System.out.println(convertDateToString(Calendar.getInstance(), "DD/MM/YYYY
			// HH:MI:SS"));
			Date nowTime = getDate("15/05/2018 15:03:36");
			Date nowTime1 = new Date();
			// System.out.println("sssssss:"+nowTime1.getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getDateString(Date date, PATTERN pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern.getValue());
		return sdf.format(date);
	}

	public static String getDateString(String date, String pattern, String pattern2) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date _date = new Date();
		try {
			_date = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sdf = new SimpleDateFormat(pattern2);
		return sdf.format(_date);
	}

	public static enum PATTERN {
		ddMMyyyy("dd/MM/yyyy"), yyyyMMdd("yyyy/MM/dd"), ddMMyyyyHHMISS("dd/MM/yyyy HH:mm:ss"), yyyy_MM_dd("yyyy-MM-dd"),
		yyyyMMddHHMISS("yyyy-MM-dd HH:mm:ss"), yyyyMMddHHmmss("yyyyMMddHHmmss"), yyyy_MM_24dd("yyyyMMdd"),
		YYYYMMDD("yyyyMMdd"), DDMMYYYY("ddMMyyyy"), MMDDYYY("MMddyyyy"), YYMMDD("yyMMdd"),
		TIMESTAMP("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"), HHmmss("HHmmss"), YYYYDDDHHMMSS("yyyyDDDHHmmss"), HHmm("HHmm");

		private String key;

		// @formatter:on
		private PATTERN(String key) {
			this.key = key;
		}

		public String getValue() {
			return this.key;
		}
	}

	public static Date convertToDate(String time, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date _oneDate = null;
		try {
			if (!StringUtils.isNullOrEmpty(time))
				_oneDate = sdf.parse(time);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return _oneDate;
	}

	public static String getDateNow() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			return sdf.format(new Date());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getDayNow() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("MMDDhhmmss");

			return sdf.format(new Date());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static int compareTwoDate(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		if (cal1.equals(cal2)) {
			return 0;
		} else if (cal1.after(cal2)) {
			return 1;
		} else {
			return -1;
		}
	}

	public static String getCurrentDateGMT() {

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss.sss");
		Date date = new Date();
		ZoneId zone = ZoneId.of("Asia/Saigon");
		sdf.setTimeZone(TimeZone.getTimeZone(zone));

		ZoneOffset offsetToday = OffsetDateTime.now(zone).getOffset();

		return sdf.format(date) + offsetToday;
	}

	public static String getCurrentDateGMTZ() {

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss.sss");
		Date date = new Date();
		ZoneId zone = ZoneId.of("Asia/Saigon");
		sdf.setTimeZone(TimeZone.getTimeZone(zone));

		// ZoneOffset offsetToday = OffsetDateTime.now(zone).getOffset();

		return sdf.format(date) + "Z";
	}

	public static String getDateTran(String date) {
		try {
			SimpleDateFormat sdf21 = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.SSS");
			SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");

			return sdf.format(sdf21.parse(date));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static String getCurrentDateTran() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");

			return sdf.format(new Date());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static String getCurrentDateTimeZoneZ() {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd hh:mm a zzz");
		// SimpleDateFormat sdf = new
		// SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss.sss±hh:mm");
		// SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss.sssZ");
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss.sss");
		Date date = new Date();
		sdf.setTimeZone(TimeZone.getTimeZone("UTC+7:00"));
		return sdf.format(date) + "Z";
	}

	/**
	 * Convert date to text with the custom format
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDateToString(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.format(date);
		} catch (Exception e) {
			return StringUtils.EMPTY;
		}
	}

	public static Date parseStringToDate(String date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Parse string to date with dd/MM/yyyy format
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseDateToString(String date) {
		return parseStringToDate(date, PATTERN.ddMMyyyy.getValue());
	}

	/**
	 * Convert current date with format dd/MM/yyyy
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		return formatDateToString(new Date(), PATTERN.ddMMyyyy.getValue());

	}

	/**
	 * Convert current date with the custom format
	 * 
	 * @return
	 */
	public static String getCurrentDate(String format) {
		return formatDateToString(new Date(), format);
	}

	public static String getCurrentTimestamp(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			Date date = new Date();
			Timestamp ts = new Timestamp(date.getTime());
			return formatter.format(ts);
		} catch (Exception e) {
			return StringUtils.EMPTY;
		}
	}

	public static String getTimeTran(String date) {
		try {
			SimpleDateFormat sdf21 = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.SSS");
			SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");

			return sdf.format(sdf21.parse(date));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static String convertBetweenTwoPatterns(String date, String src, String tag) {
		try {
			SimpleDateFormat srcFormat = new SimpleDateFormat(src);
			SimpleDateFormat tagFormat = new SimpleDateFormat(tag);

			return tagFormat.format(srcFormat.parse(date));
		} catch (Exception e) {
			return date;
		}
	}

	public static String getNowDateFMT() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(new Date());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static String convertStringToDateToString(String s, String formatDate, String formatStr) {
		if (s == null || s.isEmpty()) {
			return null;
		}
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(formatDate);
			Date date = dateFormat.parse(s);
			if (date != null) {
				SimpleDateFormat stringFormat = new SimpleDateFormat(formatStr);
				s = stringFormat.format(date);
			}
		} catch (Exception e) {
			return null;
		}
		return s;
	}

	public static String formatDatetime(String val) {
		String val1 = val;
		if (val.length() >= 10) {
			val1 = val.substring(6, 10) + val.substring(3, 5) + val.substring(0, 2);
		} else if (val.length() == 8) {
			val1 = val.substring(4, 8) + val.substring(2, 4) + val.substring(0, 2);
		} else if (val.length() == 6) {
			Date date = DateTimeUtils.convertToDate(val, "yyMMdd");
			val1 = DateTimeUtils.convertDateToString(date, PATTERN.YYYYMMDD.getValue());
		}

		System.out.println(val1);
		return val1;

	}

	public static String formatDatetime2(String val) {
		String val1 = val;
		if (val.length() >= 10) {
			val1 = val.substring(6, 10) + val.substring(3, 5) + val.substring(0, 2);
		} else if (val.length() == 8) {
			val1 = val.substring(4, 8) + val.substring(2, 4) + val.substring(0, 2);
		} else if (val.length() == 6) {
			Date date = DateTimeUtils.convertToDate(val, "ddMMyy");
			val1 = DateTimeUtils.convertDateToString(date, PATTERN.YYYYMMDD.getValue());
		}

		System.out.println(val1);
		return val1;
	}

	public static String getSysDateTime(String format) {
		try {
			final Date date = new Date(System.currentTimeMillis());
			final SimpleDateFormat simpleDateFormat;
			(simpleDateFormat = new SimpleDateFormat(format)).setTimeZone(TimeZone.getTimeZone("GMT+7"));
			format = simpleDateFormat.format(date);
		} catch (Exception ex) {
			format = "";
		}
		return format;
	}

	public static Date getTruncDate(Date date) {
		return DateUtils.truncate(date, Calendar.DATE);
	}

	public static Date getAddDate(Date date, int year) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, year);
		return c.getTime();

	}

	public static Date getMgfdate(String year) {
		return convertStringToDate(year + "0101", PATTERN.yyyy_MM_24dd.getValue());
	}
}
