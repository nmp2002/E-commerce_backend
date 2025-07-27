package com.ttisv.common.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.time.DateUtils;

public class NumberUtils {

	
	private final static String EMPTY = "";

	public static long getGiatt(long price, Date saleDate) {
		try {
			Date datecur = DateUtils.truncate(new Date(), Calendar.DATE);
			double month = (double) (DateTimeUtils.getDimdd(saleDate, datecur)) / 365;
			System.out.println(month);
			DecimalFormat df1 = new DecimalFormat("###.#####");
			double dmonth = Double.parseDouble(df1.format(month));
			double v1 = Math.pow(0.95, dmonth);
			double pricekhauhao = price * v1;
			double pricekhauhaor = (double) (Math.round(pricekhauhao) / 1000000d);

			DecimalFormat df = new DecimalFormat("###");
			long kq = getLongval(df.format(pricekhauhaor)) * 1000000;
			return kq;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return price;

	}

	public static BigDecimal getGiatt(BigDecimal price, Date saleDate, Date datecur, int khautru) {
		try {
			datecur = DateUtils.truncate(datecur, Calendar.DATE);
			double month = (double) (DateTimeUtils.getDimdd(saleDate, datecur)) / 365;
			System.out.println(month);
			DecimalFormat df1 = new DecimalFormat("###.##");
			double dmonth = Double.parseDouble(df1.format(month));
			double rate=(double)(100-khautru)/100;
			double v1 = Math.pow(rate, dmonth);
			double pricekhauhao = NumberUtils.getBigtoLong(price) * v1;
			double pricekhauhaor = (double) (Math.round(pricekhauhao) / 1000000d);

			DecimalFormat df = new DecimalFormat("###");
			long kq = getLongval(df.format(pricekhauhaor)) * 1000000;
			return NumberUtils.getDecimal(kq + "");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return price;

	}

	public static void main(String[] args) {
		System.out.println(roundOff(1.333444f, 2));
		String saleDatestr = "2021-12-03T00:00:00";
		if (StringUtils.isNotEmpty(saleDatestr) && saleDatestr.length() >= 0) {
			saleDatestr = saleDatestr.substring(0, 10);
		}
		System.out.println(DateTimeUtils.parseStringToDate(saleDatestr, "yyyy-MM-dd"));
		long v = 955000000l;
		Date date3 = DateTimeUtils.convertToDate("20230201", "yyyyMMdd");
		Date date4 = DateTimeUtils.convertToDate("20230301", "yyyyMMdd");
		// Date date4 = DateTimeUtils.convertToDate("20230301", "yyyyMMdd");
		DateTimeUtils.getDimdd(date3, date4);
		System.out.println("---------------" + DateTimeUtils.getDimdd(date3, date4));
		Date date5 = DateTimeUtils.convertToDate("20240215", "yyyyMMdd");

		Calendar c = Calendar.getInstance();
		c.setTime(date4);
		c.add(Calendar.YEAR, 1);
		c.add(Calendar.DATE, 14);
		System.out.println("----sss-----------" + c.getTime());
		System.out.println("------fffff---------" + DateTimeUtils.getDimdd(date4, c.getTime()));

		Date date = DateTimeUtils.convertToDate("20220327", "yyyyMMdd");
		System.out.println(saleDatestr + "---------------");
		// System.out.println(giatt(v,date)+"---------------");
		// TODO Auto-generated method stub
		double a = Math.pow(0.95, 0);
		System.out.println(a);

		double a1 = (double) ((Math.round(955001200d) / 1000d) * 1000d);
		System.out.println(a1);

		DecimalFormat df = new DecimalFormat("###");

		Date date1 = DateTimeUtils.convertToDate("20230327", "yyyyMMdd");
		BigDecimal dda = NumberUtils.getDecimal(1122 + "");
		double z = (double) (DateTimeUtils.getDimdd(date, date1) + 1) / 365;// (double) 5 / 12;// (double)
																			// getDimdd(date,date1)/36;
		DecimalFormat df1 = new DecimalFormat("###.#####");
		// System.out.println("sssssss33333333------- :"+df1.format(z));
		double d = Double.parseDouble(df1.format(z));
		double v1 = Math.pow(0.95, d);
		double a22 = v * v1;
		double a3 = (double) (Math.round(a22) / 1000000d);
		System.out.println("sssssss33333333 :" + d);
		System.out.println(df.format(a3));
		long aaa = getLongval(df.format(a3)) * 1000000;
		System.out.println(aaa);
		Date dateSync = DateUtils.truncate(new Date(), Calendar.DATE);
		System.out.println(dateSync);

	}

	public static double roundOff(double x, int position) {
		return BigDecimal.valueOf(x).setScale(position, BigDecimal.ROUND_HALF_DOWN).doubleValue();
		/*
		 * float a = x; double temp = Math.pow(10.0, position); a *= temp; a =
		 * Math.round(a); return (a / (float)temp);
		 */
	}

	public static double roundOfflong(double  x) {
		return  (double) Math.round(x);
				
//				BigDecimal.valueOf(x).setScale(position, BigDecimal.ROUND_HALF_DOWN).floatValue();
		/*
		 * float a = x; double temp = Math.pow(10.0, position); a *= temp; a =
		 * Math.round(a); return (a / (float)temp);
		 */
	}
	public static BigDecimal getDecimalFormat(String value) {
		try {
			if (value != null) {
				value = value.replace(",", "");
				return new BigDecimal(value);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public static BigDecimal getDecimal(String value) {
		try {
			if (value != null)
				return new BigDecimal(value);
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public static String formatVNDCurrency(BigDecimal value) {
		try {
			String pattern = "###,###.##";
			Locale locale = new Locale("vi", "VN");
			DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
			decimalFormat.applyPattern(pattern);
			return decimalFormat.format(value);
		} catch (Exception e) {
			return EMPTY;
		}
	}

	public static String convertBigdecimalFormatToString(BigDecimal val) {
		// DecimalFormat formatter = new DecimalFormat("###.00");
		DecimalFormat formatter = new DecimalFormat("##0.00");
		if (val == null)
			return "0.00";
		String a = formatter.format(val);
		return a;
	}

	public static String convertBigdecimalFormatToString2(BigDecimal val) {
		// DecimalFormat formatter = new DecimalFormat("###.00");
		DecimalFormat formatter = new DecimalFormat("##0");
		if (val == null)
			return "0";
		String a = formatter.format(val);
		return a;
	}

	public static String convertBigdecimalFormatToString3(BigDecimal val) {
		// DecimalFormat formatter = new DecimalFormat("###.00");
		DecimalFormat formatter = new DecimalFormat("##0.000");
		if (val == null)
			return "0.00";
		String a = formatter.format(val);
		return a;
	}

	public static String convertBigdecimalFormatToString4(BigDecimal val) {
		DecimalFormat formatter = new DecimalFormat("#,##0");
		if (val == null)
			return "";
		String a = formatter.format(val);
		return a;
	}

	public static boolean isZero(String value) {
		value = value.trim();
		if (value != null && value != "") {
			try {
				BigDecimal num = new BigDecimal(value);
				if (!(num.compareTo(BigDecimal.ZERO) == 0))
					return false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static BigInteger getBigInteger(String value) {
		try {
			if (value != null)
				return new BigInteger(value);
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public static long getBigtoLong(BigDecimal value) {
		try {
			if (value != null)
				return value.longValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static float getBigtoFloat(BigDecimal value) {
		try {
			if (value != null)
				return value.floatValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static double getBigtoDouble(BigDecimal value) {
		try {
			if (value != null)
				return value.doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static Integer getInteger(String value) {
		try {
			if (value != null)
				return new Integer(value);
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public static Integer convertToNum(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return 0;
		}
	}

	public static Long getLong(String value) {
		try {
			if (value != null)
				return new Long(value);
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public static long getLongval(String value) {
		try {
			if (value != null)
				return new Long(value);
		} catch (Exception e) {

		}
		return 0l;
	}

	public static long getDoubleLong(Double value) {
		try {

			return value.longValue();
		} catch (Exception e) {

		}
		return 0l;
	}
	
	public static long getFloatLong(Float value) {
		try {

			return value.longValue();
		} catch (Exception e) {

		}
		return 0l;
	}
}
