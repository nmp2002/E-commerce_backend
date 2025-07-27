package com.ttisv.common.utils;

import java.security.SecureRandom;
import java.util.Base64;


public class SecureTokenGenerator {
	public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	// 2048 bit keys should be secure until 2030 - https://web.archive.org/web/20170417095741/https://www.emc.com/emc-plus/rsa-labs/historical/twirl-and-rsa-key-size.htm
	public static final int SECURE_TOKEN_LENGTH = 24;

	private static final SecureRandom random = new SecureRandom();

	private static final char[] symbols = CHARACTERS.toCharArray();

	private static final char[] buf = new char[SECURE_TOKEN_LENGTH];

	/**
	 * Generate the next secure random token in the series.
	 */
	public static String nextToken() {
	    for (int idx = 0; idx < buf.length; ++idx)
	        buf[idx] = symbols[random.nextInt(symbols.length)];
	    return new String(buf);
	}
	public static void main(String[] args) {
		System.out.println(nextToken());
	}
	
	private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

	public static String generateNewToken() {
	    byte[] randomBytes = new byte[24];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}
}
