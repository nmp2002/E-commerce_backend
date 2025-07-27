package com.ttisv.common.sig;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class AsymmetricCryptography {
	private Cipher cipher;
	
	public AsymmetricCryptography() throws NoSuchAlgorithmException, NoSuchPaddingException{
		this.cipher = Cipher.getInstance("RSA");
	}
	

	public byte[] encryptText(byte[] msg, PublicKey key) throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
		this.cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(msg);
	}
	
	public byte[] decryptText(byte[] msg, PrivateKey key) throws InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException{
		this.cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(msg);
	}
	
	public PublicKey getPublicKeyBase64(String filename) throws CertificateException, IOException {
		String cert = new String(Files.readAllBytes(Paths.get(filename)));
		cert = cert.replace("-----BEGIN CERTIFICATE-----\r\n", "");
		cert = cert.replace("-----END CERTIFICATE-----\r\n", "");
		cert = cert.replaceAll("\r\n", "");
        byte[] decodedCert = Base64.getDecoder().decode(cert);
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        InputStream in = new ByteArrayInputStream(decodedCert);
        X509Certificate certificate = (X509Certificate)certFactory.generateCertificate(in);
        return certificate.getPublicKey();
	}

}