package com.ttisv.common;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DESUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(DESUtils.class);

    private static Cipher encryptCipher = null;
    private static Cipher decryptCipher = null;

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
            return new String(encodedBytes);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return encryptS;
    }

    public static String decrypt(String encryptedString,String pwd){
        String decryptS = null;
        try {
            DESKeySpec key = new DESKeySpec(pwd.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

            encryptCipher = Cipher.getInstance("DES");
            decryptCipher = Cipher.getInstance("DES");
            encryptCipher.init(Cipher.ENCRYPT_MODE, keyFactory.generateSecret(key));
            decryptCipher.init(Cipher.DECRYPT_MODE, keyFactory.generateSecret(key));
            byte[] decodedBytes = Base64.getUrlDecoder().decode(encryptedString.getBytes());
            byte[] unencryptedByteArray = decryptCipher.doFinal(decodedBytes);
            return new String(unencryptedByteArray, "UTF8");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return decryptS;
    }
}
