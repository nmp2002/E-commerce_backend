package com.ttisv.common.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class Utils {
	public static 	boolean isJWTExpired(String jwtString) {
		DecodedJWT decodedJWT = JWT.decode(jwtString);
		Date expiresAt = decodedJWT.getExpiresAt();
		System.out.print(expiresAt);
		return expiresAt.before(new Date());
	}

	public static String NormalizerNFC(String value)
	{
		if(StringUtils.isNotEmpty(value))
		value= Normalizer.normalize(value, Normalizer.Form.NFC).replaceAll("\\p{M}", "");
		return value;
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
		} else if ("MMYYYY".equals(format)) {
			return mm + yyyy;
		} else if ("DD-MMM-YYYY HH:MI:SS".equals(format)) {
			SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			return format2.format(d.getTime());
		} else if ("YYYYMMDDHH24MISSMS".equals(format)) {
			return yyyy + mm + dd + hh + mi + ss + ms;
		} else if ("yyyyDDDHHmmss".equals(format)) {
			SimpleDateFormat format2 = new SimpleDateFormat(format);
			return format2.format(d.getTime());
		}
		return null;
	}

	public static String convertBigDecimaltoString(BigDecimal val) {
		if (val != null)
			val.toString();
		return "";
	}

	public static Calendar convertStringToDate(String strDate, String format) {
		String dateValue;
		String timeValue;
		String[] dElement;
		String[] tElement;
		Calendar cal = null;
		if ("DD/MM/YYYY".equals(format)) {
			dElement = strDate.split("/");
			cal = Calendar.getInstance();
			cal.set(Calendar.DAY_OF_MONTH, new Integer(dElement[0]).intValue());
			cal.set(Calendar.MONTH, new Integer(dElement[1]).intValue() - 1);
			cal.set(Calendar.YEAR, new Integer(dElement[2]).intValue());
		} else if ("DD/MM/YYYY HH:MI:SS".equals(format)) {
			dateValue = strDate.substring(0, strDate.indexOf(" "));
			timeValue = strDate.substring(strDate.indexOf(" ") + 1);
			dElement = dateValue.split("/");
			tElement = timeValue.split(":");
			cal = Calendar.getInstance();
			cal.set(Calendar.DAY_OF_MONTH, new Integer(dElement[0]).intValue());
			cal.set(Calendar.MONTH, new Integer(dElement[1]).intValue() - 1);
			cal.set(Calendar.YEAR, new Integer(dElement[2]).intValue());
			cal.set(Calendar.HOUR_OF_DAY, new Integer(tElement[0]).intValue());
			cal.set(Calendar.MINUTE, new Integer(tElement[1]).intValue());
			cal.set(Calendar.SECOND, new Integer(tElement[2]).intValue());
		}

		return cal;
	}

	public static String convertDateToString(java.util.Date d, String format) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return convertDateToString(c, format);
	}

	public static BigInteger convertHexToDec(String hexStr) throws NumberFormatException {
		String hexValue = hexStr.replaceAll(" ", "");
		return new BigInteger(hexValue, 16);
	}

	public static String convertDecToHex(String decStr) {
		try {
			BigInteger decValue = new BigInteger(decStr);
			String hexValue = decValue.toString(16);
			int len = hexValue.length();
			String strHex = "";
			for (int i = 0; i < len; i = i + 1) {
				if (i % 2 == 0) {
					strHex = strHex + hexValue.substring(i, i + 1);
				} else
					strHex = strHex + hexValue.substring(i, i + 1) + " ";
			}
			return strHex.trim();
		} catch (Exception e) {
			return decStr;
		}
	}

	public static class PasswordUtil {
		public static String getMixRandom(int length) throws Exception {
			// int maxNum = 36;
			char chars[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
					's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < length; i++) {
				int randomNum = (int) (Math.random() * 36D);
				str.append(chars[randomNum]);
			}

			return str.toString();
		}
	}

	public static String generateTvanUserPwd() {
		String pwd = null;
		try {
			pwd = PasswordUtil.getMixRandom(8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String md5Pwd = MD5Password.MD5Pwd(pwd);
		return md5Pwd;
	}

	public static byte[] trim(byte[] message) {
		String msg = null;
		try {
			msg = new String(message, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// msg = StringUtils.trim(msg);
		msg = msg.replaceAll(">\\s+<", "><");
		return getByte(msg);
	}

	public static byte[] getByte(String message) {
		try {
			return message.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	public static String generateTransactionId(String codeapp, String seq) {
		String value = "";
		try {
			int length = seq.length();
			String seqvalue = "";
			if (length < 10) {
				for (int i = 0; i < 10 - length; i++)
					seqvalue = seqvalue + "0";
			}
			seqvalue = seqvalue + seq;

			String year = convertDateToString(new java.util.Date(), "YYYY");
			value = codeapp + year + seqvalue;
		} catch (Exception ex) {

		}
		if (value == null || value == "")
			value = generateTransactionIdRamdon();
		return value;
	}

	public static String generaMagiaodich(String magiaodich, String vanId, String seq) {
		String vanApp = getMaVanApp(vanId);
		if (magiaodich != null && !magiaodich.substring(0, 3).contains(vanApp)) {
			magiaodich = generateTransactionId(vanApp, seq);
		}
		return magiaodich;

	}

	public static String getMaVanApp(String vanId) {
		String vanApp = "112";
		if (vanId.equals("00001"))
			vanApp = "201";
		else if (vanId.equals("00002"))
			vanApp = "202";
		else if (vanId.equals("00003"))
			vanApp = "203";
		else if (vanId.equals("00004"))
			vanApp = "214";
		else if (vanId.equals("00005"))
			vanApp = "215";

		else if (vanId.equals("00006"))
			vanApp = "216";
		else if (vanId.equals("00007"))
			vanApp = "217";
		return vanApp;
	}

	public static String generateTransactionIdRamdon() {
		String random = "";
		try {
			String validDigits = "1234567890";
			String randomDigIdx1 = "";
			Random randomRenerator = new Random();

			for (int i = 0; i < 17; i++) {
				randomDigIdx1 += "" + randomRenerator.nextInt(validDigits.length());
			}
			random = randomDigIdx1;
		} catch (Exception ex) {

		}
		return random;
	}

	public static String getSenderNoNTDT(String senderCodeFull) {
		int indexOf = senderCodeFull.indexOf("_", 0);
		String code = senderCodeFull.substring(indexOf + 1);
		return code;
	}

	protected static SecureRandom random = new SecureRandom();

	/***
	 * 
	 * @param tokenType (HS256, HS256, HS512, RSH256, RS512)
	 * @param appCode
	 * @param startDate (dd-mm-yyyy)
	 * @param endDate   (dd-mm-yyyy)
	 * @return
	 */

	public static String generateToken(String tokenType, String appCode, String startDate, String endDate) {

		long longToken = Math.abs(random.nextLong());
		String random = Long.toString(longToken, 16);

		System.out.println(random);
		random = Base64.getEncoder().encodeToString(random.getBytes());
		return random;
	}

	public static void main(String[] args) {
		String aa="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjEwMDY5MyIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJBUElfVEkiLCJBc3BOZXQuSWRlbnRpdHkuU2VjdXJpdHlTdGFtcCI6IkxCS1NSVU9TRkMzUVpaV01RM1laUkREM0JERkhDUlBSIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiVXNlciIsImh0dHA6Ly93d3cuYXNwbmV0Ym9pbGVycGxhdGUuY29tL2lkZW50aXR5L2NsYWltcy90ZW5hbnRJZCI6IjEwMDUiLCJzdWIiOiIxMDA2OTMiLCJqdGkiOiIwZDdiMTM0Mi1mMjIwLTQ5OTktYmM5Zi1jMWZkYTIzMWYyMDciLCJpYXQiOjE2ODAzMzg1OTQsInRva2VuX3ZhbGlkaXR5X2tleSI6ImU2YzlmNTM3LTEyNDAtNDkxNi1hY2IyLTE3ZWIxNzU0ZWUzZiIsInVzZXJfaWRlbnRpZmllciI6IjEwMDY5M0AxMDA1IiwidG9rZW5fdHlwZSI6IjAiLCJuYmYiOjE2ODAzMzg1OTQsImV4cCI6MTY4MDM3NjM5OSwiaXNzIjoidG1zcyIsImF1ZCI6InRtc3MifQ.WrK3fDvWQWr0K84W7fX05qH2T2mv77qAPrhU7MNDSj8";
	 boolean a=isJWTExpired(aa);
	 System.out.print(a);
//	String token=	generateToken();
		// String random = Base64.getEncoder().encodeToString(token.getBytes());
		// System.out.println(token);

		// String random1 =new String(Base64.getDecoder().decode(token.getBytes()));
		// System.out.println(random1);
//		String aa = getRandomUUID("");
//		
//		System.out.println(convertHexToDec("54010e001a82b4ea7d6edbc9b7ed3399"));

		String str = "ACSP:-NAUT - ! à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ ì|í|ị|ỉ|ĩ ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ ỳ|ý|ỵ|ỷ|ỹ đ À|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ Ì|Í|Ị|Ỉ|Ĩ Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ Ỳ|Ý|Ỵ|Ỷ|Ỹ Đ";
		System.out.println(str);
		String str1 = unAccent(str);
		String str2 = toKhongDau(str);
//		String str2 = decodeSpecialChar("CTY XNK asc(38) DAU TU CHO LON");
		System.out.println(str1);
		System.out.println(str2);
	}

	public static String getRandomUUID(String appId) {
		if (appId == null || appId == "") {
			appId = "FS";
		}
		String uniqueID = appId + "_" + UUID.randomUUID().toString();
		return uniqueID;
	}

	public static boolean checkFileExp(String fileExp, String typesFile) {
		System.out.println("aaaaa");
		String[] checkFormat = typesFile.split("[;,|]");
		for (String s : checkFormat) {
			if (s.trim().equals(fileExp.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkSizeFile(byte[] bytes, Long maxSize) {
		if (bytes.length > (maxSize * 1024L * 1024L)) {
			return false;
		}
		return true;
	}

	public static String encodeSpecialChar(String strIn) {
		String strOut = strIn;
		try {
			if (strIn != null && !strIn.equals("")) {
				if (strIn.matches(
						".*[\\\\^|\\\\#|\\\\||\\\\*|\\\\@|\\\\$|\\\\~|\\\\!|\\\\%|\\\\&|\\\\{|\\\\}|\\\\\\[|\\\\\\]|\\\\?|\\\\<|\\\\>|\\\\\\\"|\\\\']+.*")) {
					char[] arrSpecialChar = "^#|*@$~!%&{}[]?<>\"'".toCharArray();
					for (char c : arrSpecialChar) {
						strOut = strOut.replace(Character.toString(c), "asc(" + String.valueOf((int) c) + ")");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strOut;
	}

	public static String decodeSpecialChar(String strIn) {
		try {
			if (strIn != null && !strIn.equals("")) {
				strIn = strIn.replace("ASC(", "asc(");
				String strOut = strIn;
				String strParten = "asc\\(([0-9]{1,3})\\)";
				Pattern pattern = Pattern.compile(strParten);
				Matcher matcher = pattern.matcher(strIn);
				while (matcher.find()) {
					// Get the matching string
					String match = matcher.group();
					strOut = strOut.replace(match, Character
							.toString((char) Integer.parseInt(match.replace("asc(", "").replace(")", "").trim())));
//		      strOut=strOut.replace(match, Character.toString((char)Integer.parseInt(match.replace("asc(","").replace("ASC(","").replace(")","").trim())));
				}
				return strOut;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strIn;

	}

	public static String unAccent(String s) {
		if (StringUtils.isNullOrEmpty(s))
			return s;
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "d");// .replace("!|@|%|\\^|\\*|\\(|\\)|\\+|\\=|\\&lt;|\\&gt;|\\?|\\/|,|\\.|\\:|\\;|\\'|
																							// |\\\"|\\&amp;|\\#|\\[|\\]|~|$|","-");
																							// //.replaceAll("[^\\w\\s]",
																							// "");
	}

	public static String toKhongDau(String str) {
		try {
			String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(temp).replaceAll("").replaceAll(" ", "-").replaceAll("Đ", "D").replaceAll("đ", "d");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
}
