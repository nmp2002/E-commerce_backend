package com.ttisv.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.util.Base64;

public class StringUtils {
	public static final String EMPTY = "";
	public static final String SPACE = " ";
	public static final String REGEX_NUMBER = "[0-9]+";

	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.trim().isEmpty() || "null".equals(str)) {
			return true;
		}
		return false;
	}

	public static String getValue(BigDecimal value) {
		if (value == null)
			return "";
		return value.toString();
	}

	public static String convertBDToString(BigDecimal value) {
		if (value == null)
			return "0";
		return String.valueOf(value.setScale(0, BigDecimal.ROUND_HALF_UP));
	}

	public static String getNonNullValue(BigDecimal value) {
		if (value == null)
			return "0.00";
		return value.toString();
	}

	public static String getNonNullValue(String value) {
		if (value == null || value.equals("null"))
			return "";
		return value.trim();
	}

	public static String getNonNullValue(long value) {
		if (value == 0)
			return "";
		return String.valueOf(value);
	}

	public static String getNonNullValueInt(Integer value) {
		if (value == null || value == 0)
			return "";
		return String.valueOf(value);
	}

	public static String trim(String input) {
		BufferedReader reader = new BufferedReader(new StringReader(input));
		StringBuffer result = new StringBuffer();
		try {
			String line;
			while ((line = reader.readLine()) != null)
				result.append(line.trim());
			return result.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getAsString(Clob clob) {
		Reader reader = null;
		BufferedReader bufferedReader = null;
		try {
			reader = clob.getCharacterStream();
			bufferedReader = new BufferedReader(reader);
			return IOUtils.toString(bufferedReader);

		} catch (Exception e) {
			throw new RuntimeException("Error while reading String from CLOB", e);
		} finally {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(bufferedReader);
		}
	}

	public static boolean isEmpty(String value) {
		if (value == null || EMPTY.equals(value.trim()))
			return true;
		return false;
	}

	public static int convertStringToNumber(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static Long convertStringToLong(String str) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			return 0L;
		}
	}

	public static BigDecimal convertMoney(String str) {
		try {
			return new BigDecimal(str);
		} catch (NumberFormatException e) {
			return BigDecimal.ZERO;
		}
	}

	public static String getShortStr(String str, int number) {
		String value = "";
		try {
			if (str != null && !str.isEmpty()) {
				int size = str.length();
				if (number < size) {
					value = str.substring(0, number);
				} else {
					value = str;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return value;
	}

	public static boolean validFieldIsNULL(String value, int minlength, int maxlength) {
		if (isNullOrEmpty(value)) {
			return true;
		}
		if (value.length() < minlength || value.length() > maxlength) {
			return false;
		}

		return true;

	}

	public static boolean validField(String value, int minlength, int maxlength) {
		if (isNullOrEmpty(value)) {
			return false;
		}
		if (value.length() < minlength || value.length() > maxlength) {
			return false;
		}

		return true;
	}

	public static boolean validField(String value, int minlength, int maxlength, String reg) {
		if (isNullOrEmpty(value)) {
			return false;
		}
		if (value.length() < minlength || value.length() > maxlength) {
			return false;
		}
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(value);
		System.out.println(matcher.matches());
		boolean aa = matcher.matches();
		return matcher.matches();
	}

	public static String subStringMaster(String str, int beginIndex, int endIndex) {
		if (isNullOrEmpty(str)) {
			return EMPTY;
		}
		try {
			return str.substring(beginIndex, endIndex);
		} catch (IndexOutOfBoundsException e) {
			return EMPTY;
		}
	}

	public static boolean isNotEmpty(String str) {
		return !StringUtils.isEmpty(str);
	}

	public static boolean checkNumber(String str) {
		if (isNullOrEmpty(str)) {
			return false;
		}
		return str.matches(REGEX_NUMBER);
	}

	public static String removeBreaksLine(String message) {
		if (StringUtils.isNullOrEmpty(message)) {
			return null;
		}
		return message.replace("\n", "").replace("\r", "");
	}

	public static byte[] toBase64(String val) {
		if (!isNullOrEmpty(val)) {
			byte[] bytesEncoded = Base64.encodeBase64(val.getBytes());

			return bytesEncoded;
		}
		return null;
	}

	public static String clearAmount(String val) {
		try {
			if (org.apache.commons.lang.StringUtils.isNotBlank(val)) {
				if (val.length() > 3) {
					String charLast = val.substring(val.length() - 3, val.length());
					if (charLast.equals(".00") || charLast.equals(",00")) {
						val = val.substring(0, val.length() - 3).replaceAll("[^0-9]+", "");
					} else {
						val = val.replaceAll("[^0-9]+", "");
					}
				} else {
					val = val.replaceAll("[^0-9]+", "");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("ERROR StringUtils.clearAmount " + e.getMessage());
		}
		return val;
	}

	public static String clearChar(String val) {
		if (org.apache.commons.lang.StringUtils.isNotBlank(val)) {
			return val.replaceAll("[^0-9a-zA-Z]", "");
		}
		return "";
	}

	public static String formatTien(String moneyBigDec1, String loaiTien) {
		String moneyLast = "";
		BigDecimal moneyBigDec = BigDecimal.ZERO;

		if (StringUtils.isNullOrEmpty(moneyBigDec1)) {
			return moneyLast;
		} else {
			moneyBigDec = new BigDecimal(moneyBigDec1);
		}

		if ("VND".equalsIgnoreCase(loaiTien) || "VNĐ".equalsIgnoreCase(loaiTien) || loaiTien.isEmpty()) {
			DecimalFormat df = new DecimalFormat("#,###");
			moneyLast = df.format(moneyBigDec);
		} else {
			DecimalFormat df = new DecimalFormat("#,##0.00");
			moneyLast = df.format(moneyBigDec);
		}
		moneyLast = moneyLast.replace(",", "-");
		moneyLast = moneyLast.replace(".", ",");
		moneyLast = moneyLast.replace("-", ".");
		return moneyLast;
	}

	public static Integer getFieldLength(String message) {
		if (StringUtils.isNullOrEmpty(message)) {
			return 0;
		}
		return message.length();
	}

	// Convert tieng viet sang alphabet
	public static String unAccent(String s) {
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d");
	}

	// In hoa chữ cái đầu tiên của chuỗi
	public static String capitalizeFirstLetter(String original) {
		if (original == null || original.isEmpty()) {
			return original;
		}
		return original.substring(0, 1).toUpperCase() + original.substring(1);
	}

	public static String replaceAllDot(String val) {
		if (org.apache.commons.lang.StringUtils.isNotBlank(val)) {
			return val.replaceAll("\\.", "");
		}
		return "";
	}

	// Ham tinh pham tram giua hai so Long
	public static String getPerentByTwoParam(Long divisor, Long dividend) {
		String percent = "0%";
		if (dividend == 0L || divisor == 0L) {
			return percent;
		} else {
			Float result = (float) ((float) divisor / (float) dividend * 100);
			percent = String.valueOf(Math.round(result)) + "%";
		}
		return percent;
	}

	public static List<String> splitStringToList(String strCut, String cut) {
		List<String> result = new ArrayList<>();
		if (strCut == null || strCut.isEmpty()) {
			return null;
		}
		if (strCut.contains(cut)) {
			String[] parts = strCut.split(cut);
			if (parts != null && parts.length > 0) {
				result = Arrays.asList(parts);
			}
		}
		return result;
	}

	public static String getStringTrimAllSpace(String reslt3) {
		try {
			return reslt3.replace(" ", "");
		} catch (Exception e) {
			return reslt3;
		}
	}

	public static String escapeSql(String input) {
		String result = input.trim().replace("/", "//").replace("_", "/_").replace("%", "/%");
		return result;
	}

	public static String toLikeAndLowerCaseString(String content) {
		return "%" + StringUtils.escapeSql(content.toLowerCase().trim()) + "%";
	}

	public static void main(String[] args) {
		String str = "20220530VND1000000";
		System.out.println(str);
		String reslt = subStringMaster(str, 0, 8);
		System.out.println(reslt);
		String reslt1 = subStringMaster(str, 8, 11);
		System.out.println(reslt1);
		String reslt2 = subStringMaster(str, 11, str.length());
		System.out.println(reslt2);

		String reslt3 = "02009704030609154901      MB197019";
		System.out.println(reslt3.replace(" ", ""));
	}

}
