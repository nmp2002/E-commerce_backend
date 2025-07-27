package com.ttisv.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DESUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(DESUtils.class);
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static Cipher encryptCipher = null;
    private static Cipher decryptCipher = null;
	public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
		  byte[] decodedBytes = Base64.getUrlDecoder().decode("QWdyaWJhbmtAMTIz");
		    String aa1= new String(decodedBytes, "UTF8");
		    System.out.println(aa1);
			
		String a1=encrypt("6123","12345678", true);
		System.out.println(a1);
		String a=decrypt("0EZbcVd9xuEDVqqTmI3iVw==","12345678");
		System.out.println(a);
	}
    public static String encrypt(String input, String pwd, boolean allowNull) {
    	if (!allowNull && (input == null || input.isEmpty()))
    		return "";
        String encryptS = null;
        try {
            DESKeySpec key = new DESKeySpec(pwd.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

            encryptCipher = Cipher.getInstance("DES");
            decryptCipher = Cipher.getInstance("DES");
            encryptCipher.init(Cipher.ENCRYPT_MODE, keyFactory.generateSecret(key));
            decryptCipher.init(Cipher.DECRYPT_MODE, keyFactory.generateSecret(key));
            byte[] unencryptedByteArray = input.getBytes("UTF8");
            byte[] encryptedBytes = encryptCipher.doFinal(unencryptedByteArray);
            byte[] encodedBytes = Base64.getUrlEncoder().withoutPadding().encode(encryptedBytes);
            String a= Base64Utils.base64Encode(encodedBytes);
            System.out.println("bse :"+a);
            return new String(encodedBytes);
        } catch (Exception e) {
        	e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        return encryptS;
    }

    public  static String decrypt(String encryptedString,String pwd){
        String decryptS = null;
        try {
        	decrypt1(encryptedString, pwd);
            DESKeySpec key = new DESKeySpec(pwd.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            decryptCipher = Cipher.getInstance("DES");        
            decryptCipher.init(Cipher.DECRYPT_MODE, keyFactory.generateSecret(key));
            byte[] decodedBytes = Base64.getUrlDecoder().decode(encryptedString) ; //Base64Utils.base64Decode(encryptedString);
            byte[] unencryptedByteArray = decryptCipher.doFinal(decodedBytes);
            return new String(unencryptedByteArray, "UTF8");
        } catch (Exception e) {
        	e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        return decryptS;
    }
    public static void setKey(final String myKey) {
        MessageDigest sha = null;
        try {
          key = myKey.getBytes("UTF-8");
          sha = MessageDigest.getInstance("SHA-1");
          key = sha.digest(key);
          key = Arrays.copyOf(key, 16);
          secretKey = new SecretKeySpec(key, "DES");
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

    public static String decrypt1(final String strToDecrypt, final String secret) {
        try {
          setKey(secret);
          DESKeySpec key = new DESKeySpec(secret.getBytes());
          SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
          Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
          cipher.init(Cipher.DECRYPT_MODE,  keyFactory.generateSecret(key));
        String aa=new String(cipher.doFinal(Base64.getDecoder()
            .decode(strToDecrypt)));
        System.out.println(aa);
        } catch (Exception e) {
          System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
      }
}
