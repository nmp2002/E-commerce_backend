package com.ttisv.common.sig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Logger;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class VerifyMain {

	static Logger logger = java.util.logging.Logger.getLogger("Response");

	public static void main(String[] args) {
		try {
			VerifyMain vrf = new VerifyMain();
			// vrf.verifySignText1();
			vrf.verifySignText("", "", "");
			// vrf.verifySignXML();
//        	vrf.encryptData();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void verifySignText() throws CertificateException, IOException, NoSuchAlgorithmException,
			InvalidKeyException, SignatureException, InvalidKeySpecException {
//    	String pathFile = "C:\\Users\\USER\\Desktop\\publicKeyX509.cer";
		String pathFile = "C:\\Users\\USER\\Desktop\\tctPublicKeyBase64.cer";
		// String publicKeyBase64 =
		// "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiEI2JwbnVxCZSk5mbBcK6owcX7+/h0YMOJRDXilUmRiqCKSq6muZUr+qZXawVoduwmCAbJ63lXrSUMJXnoJ1An1Ib3spPyb8n5ASn55INQNonOMbrDtkimIKVTzdntbT4/dVyaCdyt6f3EzllvVmioGpAme8djgXREg3c6CSWqGKmDEUYS7yftGHD8Wp7ZBj7NDaLGuctZhvbQQz8YFQMocq1Rxk+GErgieXuo9DZLfPWYffiwtUkmydPg8EpI/Nvb9jS7Sok7FxGKN99BpuUK4UYVG5a9LP2B+6Xp9Uc731Im5ySsoA3iSbCjowBqYTpSB/oClSOnEpuog0eaBPHwIDAQAB";
		String publicKeyBase64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqnzptnBe/LTQ6ya0seA2Hp6Tf6GCTx6iLIE6nLUyfkrlrWzP7DK3caqjncEGsQUfgl5fllTgpeYfkJHVgxb/rVh6jajwNA9JbkWug+b9MF8gPGghMWiLLAbsnllubZ97XBf/n6lPoEbYxhFsCLzvTAUxRj8Uii2JFwtWtxHxd04C+ALlcOAjImDXT2AYnBl5CsSmDOjgsNZfqQl+BoFQpAPHYk0xunxyBH+x23ckusVWGtv2xOwTUJTOd/yvevAZSyXAD7P+DOvo4ZNG9YE5UdUgaBbkptcmWZ8LVNSNpdnszXfh/7rA964q4QhKTYtdT8mWw6EauzA17Qzgz8Gl+wIDAQAB";

		// String data =
		// "eyJpZF9uaHRtIjoiODgiLCJtYV9uaHRtIjoiQWdyaWJhbmsiLCJuYW0iOiIyMDE5IiwicXV5IjoiNCIsImtsdW9uZ19reTEiOiI0MDAwIiwibHN1YXRfa3kxIjoiOC43Iiwia2x1b25nX2t5MiI6IjEwMDAwIiwibHN1YXRfa3kyIjoiOC45Iiwia2x1b25nX2t5MyI6IjEwMDAwIiwibHN1YXRfa3kzIjoiOC45In0=";
		String data = "eyJpZF9uaHRtIjoiODgiLCJtYV9uaHRtIjoiQWdyaWJhbmsiLCJuYW0iOiIyMDE5IiwicXV5IjoiNCIsImtsdW9uZ19reTEiOiI0MDAwIiwibHN1YXRfa3kxIjoiOC43Iiwia2x1b25nX2t5MiI6IjEwMDAwIiwibHN1YXRfa3kyIjoiOC45Iiwia2x1b25nX2t5MyI6IjEwMDAwIiwibHN1YXRfa3kzIjoiOC45In0=";

		// String signatureString =
		// "HmZPfvV0QHNSVYZ6pYC6MF8N6o4iUKwa3+/UUjAb6O0mUdIod0TdVdtklHrfzG4YOxlFdkXVCPv9AhvUDVC9JYM9qF6X/B0nxqBukrivSYQyl7q2fmYCN8rJhXVcNIYP7fdyUh7QqV8xGpHekDi0XuGOH1eUMZHReJro2THpo6OTDVMccsKqSsWsyjZqg2dQd7awFY0p9GyTVxkzUX/03Ur0/sl5LjVzu7c+BpgNYrRSbiR6MYYbP5IlUmRbVgUsKyz9R/b2mXNQKlZa0Rgs/0lx06Ji2vM+bo8jegyrj1Gi5WFdfNG7TYHNjTV8wGu1C+dxR3GENN1FGYqTLacmDg==";
		String signatureString = "qcYjabV4XdachwqpfUcetTcl63WGUdWPD5GUEP3vhioxQ1yyeSpFrdjz/g2/O2qoOD6+O/sBcVxghYs2MT24ybnF/GpA9mDkeOO800+EOVQvvLafjAdZnDDVzQgSy9Bze68n6/Bo0eKbQDvqrIRO/1K7weHpYZDUEsNmAAVpoyt6hJJ2u/xyIZ7KmNxfpN9DlzXeOi/32vZLy3tHaCDhSJ6xHqxyF6QYzgjX2wz1DPzF548n8Tc+xnYw3NozmHHuDMarriXt4aTz/nthDdw05S38ImKtqVtHsmzBzEARNB8NFpxO/PfGNJQZzYz+lA+mHMo9UUgse/A/yD3TweWtxw==";
		Signature sig = Signature.getInstance("SHA256withRSA");
		byte[] signatureBytes = Base64.getDecoder().decode(signatureString);
		PublicKey publicKey = getPublicKeyBase64String(publicKeyBase64);
//    	PublicKey publicKey2 = getPublicKeyBaniry(pathFile);
		sig.initVerify(publicKey);
		sig.update(Base64.getDecoder().decode(data));
		System.out.println(sig.verify(signatureBytes));
	}

	public static boolean verifySignText(String publicKeyBase64, String data, String signatureString)
			throws CertificateException, IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException,
			InvalidKeySpecException {
		// publicKeyBase64 =
		// "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqnzptnBe/LTQ6ya0seA2Hp6Tf6GCTx6iLIE6nLUyfkrlrWzP7DK3caqjncEGsQUfgl5fllTgpeYfkJHVgxb/rVh6jajwNA9JbkWug+b9MF8gPGghMWiLLAbsnllubZ97XBf/n6lPoEbYxhFsCLzvTAUxRj8Uii2JFwtWtxHxd04C+ALlcOAjImDXT2AYnBl5CsSmDOjgsNZfqQl+BoFQpAPHYk0xunxyBH+x23ckusVWGtv2xOwTUJTOd/yvevAZSyXAD7P+DOvo4ZNG9YE5UdUgaBbkptcmWZ8LVNSNpdnszXfh/7rA964q4QhKTYtdT8mWw6EauzA17Qzgz8Gl+wIDAQAB";

		// data =
		// "eyJpZF9uaHRtIjoiODgiLCJtYV9uaHRtIjoiQWdyaWJhbmsiLCJuYW0iOiIyMDE5IiwicXV5IjoiNCIsImtsdW9uZ19reTEiOiI0MDAwIiwibHN1YXRfa3kxIjoiOC43Iiwia2x1b25nX2t5MiI6IjEwMDAwIiwibHN1YXRfa3kyIjoiOC45Iiwia2x1b25nX2t5MyI6IjEwMDAwIiwibHN1YXRfa3kzIjoiOC45In0=";
		// signatureString =
		// "qcYjabV4XdachwqpfUcetTcl63WGUdWPD5GUEP3vhioxQ1yyeSpFrdjz/g2/O2qoOD6+O/sBcVxghYs2MT24ybnF/GpA9mDkeOO800+EOVQvvLafjAdZnDDVzQgSy9Bze68n6/Bo0eKbQDvqrIRO/1K7weHpYZDUEsNmAAVpoyt6hJJ2u/xyIZ7KmNxfpN9DlzXeOi/32vZLy3tHaCDhSJ6xHqxyF6QYzgjX2wz1DPzF548n8Tc+xnYw3NozmHHuDMarriXt4aTz/nthDdw05S38ImKtqVtHsmzBzEARNB8NFpxO/PfGNJQZzYz+lA+mHMo9UUgse/A/yD3TweWtxw==";

		Signature sig = Signature.getInstance("SHA256withRSA");
		byte[] signatureBytes = Base64.getDecoder().decode(signatureString);
		PublicKey publicKey = getPublicKeyBase64String(publicKeyBase64);
		sig.initVerify(publicKey);
		sig.update(Base64.getDecoder().decode(data));
		boolean isok = sig.verify(signatureBytes);
		return isok;
	}

	private void verifySignText1() throws CertificateException, IOException, NoSuchAlgorithmException,
			InvalidKeyException, SignatureException, InvalidKeySpecException {

		String publicKeyBase64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqnzptnBe/LTQ6ya0seA2Hp6Tf6GCTx6iLIE6nLUyfkrlrWzP7DK3caqjncEGsQUfgl5fllTgpeYfkJHVgxb/rVh6jajwNA9JbkWug+b9MF8gPGghMWiLLAbsnllubZ97XBf/n6lPoEbYxhFsCLzvTAUxRj8Uii2JFwtWtxHxd04C+ALlcOAjImDXT2AYnBl5CsSmDOjgsNZfqQl+BoFQpAPHYk0xunxyBH+x23ckusVWGtv2xOwTUJTOd/yvevAZSyXAD7P+DOvo4ZNG9YE5UdUgaBbkptcmWZ8LVNSNpdnszXfh/7rA964q4QhKTYtdT8mWw6EauzA17Qzgz8Gl+wIDAQAB";

		String data = "eyJpZF9uaHRtIjoiODgiLCJtYV9uaHRtIjoiQWdyaWJhbmsiLCJuYW0iOiIyMDE5IiwicXV5IjoiNCIsImtsdW9uZ19reTEiOiI0MDAwIiwibHN1YXRfa3kxIjoiOC43Iiwia2x1b25nX2t5MiI6IjEwMDAwIiwibHN1YXRfa3kyIjoiOC45Iiwia2x1b25nX2t5MyI6IjEwMDAwIiwibHN1YXRfa3kzIjoiOC45In0=";
		String signatureString = "qcYjabV4XdachwqpfUcetTcl63WGUdWPD5GUEP3vhioxQ1yyeSpFrdjz/g2/O2qoOD6+O/sBcVxghYs2MT24ybnF/GpA9mDkeOO800+EOVQvvLafjAdZnDDVzQgSy9Bze68n6/Bo0eKbQDvqrIRO/1K7weHpYZDUEsNmAAVpoyt6hJJ2u/xyIZ7KmNxfpN9DlzXeOi/32vZLy3tHaCDhSJ6xHqxyF6QYzgjX2wz1DPzF548n8Tc+xnYw3NozmHHuDMarriXt4aTz/nthDdw05S38ImKtqVtHsmzBzEARNB8NFpxO/PfGNJQZzYz+lA+mHMo9UUgse/A/yD3TweWtxw==";
		Signature sig = Signature.getInstance("SHA256withRSA");
		byte[] signatureBytes = Base64.getDecoder().decode(signatureString);
		PublicKey publicKey = getPublicKeyBase64String(publicKeyBase64);
		sig.initVerify(publicKey);
		sig.update(Base64.getDecoder().decode(data));
		System.out.println(sig.verify(signatureBytes));
	}

	private void verifySignXML() throws MarshalException, XMLSignatureException, NoSuchAlgorithmException,
			InvalidKeySpecException, CertificateException, IOException, SAXException, ParserConfigurationException {
		// Validation Signature
		String publicKeyBase64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiEI2JwbnVxCZSk5mbBcK6owcX7+/h0YMOJRDXilUmRiqCKSq6muZUr+qZXawVoduwmCAbJ63lXrSUMJXnoJ1An1Ib3spPyb8n5ASn55INQNonOMbrDtkimIKVTzdntbT4/dVyaCdyt6f3EzllvVmioGpAme8djgXREg3c6CSWqGKmDEUYS7yftGHD8Wp7ZBj7NDaLGuctZhvbQQz8YFQMocq1Rxk+GErgieXuo9DZLfPWYffiwtUkmydPg8EpI/Nvb9jS7Sok7FxGKN99BpuUK4UYVG5a9LP2B+6Xp9Uc731Im5ySsoA3iSbCjowBqYTpSB/oClSOnEpuog0eaBPHwIDAQAB";
		String data = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+PERBVEE+PEhFQURFUj48SURfTkhUTT44ODwvSURfTkhUTT48TUFfTkhUTT5BZ3JpYmFuazwvTUFfTkhUTT48TkFNPjIwMTk8L05BTT48UVVZPjQ8L1FVWT48L0hFQURFUj48Qk9EWT48S0hPSUxVT05HX0JBTkNIQU8+PEtIT0lMVU9ORyBpZD0iMSI+MTAwMDA8L0tIT0lMVU9ORz48S0hPSUxVT05HIGlkPSIyIj4xNTAwMDwvS0hPSUxVT05HPjxLSE9JTFVPTkcgaWQ9IjMiPjIwMDAwPC9LSE9JTFVPTkc+PC9LSE9JTFVPTkdfQkFOQ0hBTz48TEFJU1VBVF9CQU5DSEFPPjxMQUlTVUFUIGlkPSIxIj44LjI8L0xBSVNVQVQ+PExBSVNVQVQgaWQ9IjIiPjguNDwvTEFJU1VBVD48TEFJU1VBVCBpZD0iMyI+OC42PC9MQUlTVUFUPjwvTEFJU1VBVF9CQU5DSEFPPjwvQk9EWT48U2lnbmF0dXJlIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj48U2lnbmVkSW5mbz48Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ii8+PFNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMDQveG1sZHNpZy1tb3JlI3JzYS1zaGEyNTYiLz48UmVmZXJlbmNlIFVSST0iIj48VHJhbnNmb3Jtcz48VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI2VudmVsb3BlZC1zaWduYXR1cmUiLz48L1RyYW5zZm9ybXM+PERpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMDQveG1sZW5jI3NoYTI1NiIvPjxEaWdlc3RWYWx1ZT42czJlSDdCR0hRUTRvU2lZODJZVjZrdGVBK0hKcFJORENwTU9jSkVXRDc0PTwvRGlnZXN0VmFsdWU+PC9SZWZlcmVuY2U+PC9TaWduZWRJbmZvPjxTaWduYXR1cmVWYWx1ZT5DM3NyNnkxblRzNmZ6RklleFBxVnZDbWdIeXlGOXU1OXVvYmlNdllBcmpMVERhT2txaXN2eldMclg0NHZYM2RFRVZGdnN3cTVxL2tKDQp1dVF5VTBBeS9XTHAzc3VMTDZvUkxJcEJwZFh4ZjRHMUhwbHBPWjFBYmFjNHdBSWFweUhsVlBscjZ1cnREK29qOFp4V2FwZUo2dlVCDQpveERNRENheTluNjlhTUYzaE5Pa1VmTjlvY25jK1MwMjU0QXQ2L1MrT3VNR3Mwemk1WFJxVmczTTU4K1dPbk0xazNkSjMyK0FWMUJlDQpwUHFUMGpUeFE0ZnZCWFQ0NWFPb2FXSDZER2JGSGlnYzJ2dTBjRzdIdjlqVmpOblF2RGFYNmJqSGdndWx1OVI0REpWV1RuRnNvNmpxDQp1cHVDTHJDQ0daQlhITzQ1U1F5b0oraVVySmU1QkVxT0haaXF6UT09PC9TaWduYXR1cmVWYWx1ZT48S2V5SW5mbz48WDUwOURhdGE+PFg1MDlTdWJqZWN0TmFtZT5DPVZOLFNUPUhBTk9JLE89VOG7lE5HIEPhu6RDIFRIVeG6vixDTj1U4buUTkcgQ+G7pEMgVEhV4bq+IFRFU1QwMSAtIFNIQTI1NixVSUQ9TVNUOjAxMDAyMzEyMjYtOTk4PC9YNTA5U3ViamVjdE5hbWU+PFg1MDlDZXJ0aWZpY2F0ZT5NSUlGR1RDQ0JBR2dBd0lCQWdJUVZBRUJCUUFBQUFCWnBQdTJIVlFBYWpBTkJna3Foa2lHOXcwQkFRc0ZBREE2TVJNd0VRWURWUVFEDQpEQXBXYVdWMGRHVnNMVU5CTVJZd0ZBWURWUVFLREExV2FXVjBkR1ZzSUVkeWIzVndNUXN3Q1FZRFZRUUdFd0pXVGpBZUZ3MHhPVEEyDQpNVEl3T1RVM01EaGFGdzB5TURBMk1URXdPVFUzTURoYU1JR05NU0l3SUFZS0NaSW1pWlB5TEdRQkFRd1NUVk5VT2pBeE1EQXlNekV5DQpNall0T1RrNE1Td3dLZ1lEVlFRRERDTlU0YnVVVGtjZ1ErRzdwRU1nVkVoVjRicStJRlJGVTFRd01TQXRJRk5JUVRJMU5qRWNNQm9HDQpBMVVFQ2d3VFZPRzdsRTVISUVQaHU2UkRJRlJJVmVHNnZqRU9NQXdHQTFVRUNBd0ZTRUZPVDBreEN6QUpCZ05WQkFZVEFsWk9NSUlCDQpJakFOQmdrcWhraUc5dzBCQVFFRkFBT0NBUThBTUlJQkNnS0NBUUVBaUVJMkp3Ym5WeENaU2s1bWJCY0s2b3djWDcrL2gwWU1PSlJEDQpYaWxVbVJpcUNLU3E2bXVaVXIrcVpYYXdWb2R1d21DQWJKNjNsWHJTVU1KWG5vSjFBbjFJYjNzcFB5YjhuNUFTbjU1SU5RTm9uT01iDQpyRHRraW1JS1ZUemRudGJUNC9kVnlhQ2R5dDZmM0V6bGx2Vm1pb0dwQW1lOGRqZ1hSRWczYzZDU1dxR0ttREVVWVM3eWZ0R0hEOFdwDQo3WkJqN05EYUxHdWN0Wmh2YlFRejhZRlFNb2NxMVJ4aytHRXJnaWVYdW85RFpMZlBXWWZmaXd0VWtteWRQZzhFcEkvTnZiOWpTN1NvDQprN0Z4R0tOOTlCcHVVSzRVWVZHNWE5TFAyQis2WHA5VWM3MzFJbTV5U3NvQTNpU2JDam93QnFZVHBTQi9vQ2xTT25FcHVvZzBlYUJQDQpId0lEQVFBQm80SUJ4VENDQWNFd05nWUlLd1lCQlFVSEFRRUVLakFvTUNZR0NDc0dBUVVGQnpBQmhocG9kSFJ3T2k4dmIyTnpjREl1DQpkbWxsZEhSbGJDMWpZUzUyYmpBZEJnTlZIUTRFRmdRVTNmVW1mWnp2Q2FaMjQvc3o0Q3doTnJNWU42MHdEQVlEVlIwVEFRSC9CQUl3DQpBREFmQmdOVkhTTUVHREFXZ0JSTUE4SVQ1YWFpT29pUEQxVXovT3N5ZGUrcVJEQ0JyQVlEVlIwZ0JJR2tNSUdoTUlHZUJnb3JCZ0VFDQpBWUh0QXdFRk1JR1BNRW9HQ0NzR0FRVUZCd0lDTUQ0ZVBBQlVBR2dBYVFCekFDQUFhUUJ6QUNBQVlRQmpBR01BY2dCbEFHUUFhUUIwDQpBR1VBWkFBZ0FHTUFaUUJ5QUhRQWFRQm1BR2tBWXdCaEFIUUFaVEJCQmdnckJnRUZCUWNDQVJZMWFIUjBjRG92TDNacFpYUjBaV3d0DQpZMkV1ZG00dmRYQnNiMkZrY3k5bWFXeGxMMlJ2ZDI1c2IyRmtMME5RTFVOUVV5NXdaR1l3ZWdZRFZSMGZCSE13Y1RCdm9DMmdLNFlwDQphSFIwY0RvdkwyTnliQzUyYVdWMGRHVnNMV05oTG5adUwxWnBaWFIwWld3dFEwRXRNaTVqY215aVBxUThNRG94RXpBUkJnTlZCQU1NDQpDbFpwWlhSMFpXd3RRMEV4RmpBVUJnTlZCQW9NRFZacFpYUjBaV3dnUjNKdmRYQXhDekFKQmdOVkJBWVRBbFpPTUE0R0ExVWREd0VCDQovd1FFQXdJRjREQU5CZ2txaGtpRzl3MEJBUXNGQUFPQ0FRRUFvNjUxcnd6ZnMxYjJ0THhzK3prN0d5TDNxa0Z4clN5Uk5BMDZXMDl4DQpySkdrd0YyT3gzamhuZWZYamxJQTc1ZGRTR0VnblgxRkRHaXBteWNmd3dOdDlVblkzYW9tenJCOS9yb3Q2c3BxOGswVnZ6UWlZMnc1DQpoRGliaFg3RmJkdkVuVk11WDI2STQxWGtTS1EvZjVzQXBRRm8rTmgrcVVyQzVWeDBEY2hnN2d0OGY5Q0FjL3JxVkdtTFdONHB6cmRGDQpCcTMraG1UbVozbllPSXJhS2NoY1hGQkVRYTN5YkZ2RXRQVUFEcHREMWRTcEdUVERIeEY1anlFRVhVU2tNbWdxbXhCL1VVZ3lZVVJnDQpHMXJTMmtvZ2lIK1QrY2RHbGFoWFI5ZkVxR0hBWnR4eW4wSUV2aXlXU2RyQnp1dVpqRWRMODFNQUp0dnR3K1JrYy9kcVZURjRpQT09PC9YNTA5Q2VydGlmaWNhdGU+PC9YNTA5RGF0YT48L0tleUluZm8+PC9TaWduYXR1cmU+PC9EQVRBPg==";
		String dataXml = new String(Base64.getDecoder().decode(data), "UTF-8");
		logger.info("Parse the xml...");
		// parseDOMDocument
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		Document doc = dbf.newDocumentBuilder().parse(new InputSource(new StringReader(dataXml)));
		PublicKey pubKey = getPublicKeyBase64String(publicKeyBase64);
		// Get our Signature Element from the XML.
		boolean valid;
		logger.info("Search for the signature part in the xml...");
		NodeList nl = doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
		if (nl.getLength() == 0) {
			logger.warning("Couldn't find signature part... Can't validate file!");
			valid = false;
		} else {
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance();
			// Create a DOMValidateContext and specify a KeySelector
			// and document context.
			DOMValidateContext valContext = new DOMValidateContext(pubKey, nl.item(0));
			// Unmarshal the XMLSignature.
			XMLSignature signatureval = fac.unmarshalXMLSignature(valContext);
			// Validate the XMLSignature.
			valid = signatureval.validate(valContext);
		}
		logger.info("Signature is valid? " + valid);
	}

	private static PublicKey getPublicKeyBase64String(String cert)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] decodedCert = Base64.getDecoder().decode(cert.trim());
		KeyFactory factory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(decodedCert);
		return factory.generatePublic(encodedKeySpec);
	}

	private static PublicKey getPublicKeyBaniry(String filename) throws Exception {
		byte[] keyBytes = readFileToByteArray(new File(filename));
		CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
		InputStream in = new ByteArrayInputStream(keyBytes);
		X509Certificate certificate = (X509Certificate) certFactory.generateCertificate(in);
		return certificate.getPublicKey();
	}

	private static byte[] readFileToByteArray(File file) {
		FileInputStream fis = null;
		// Creating a byte array using the length of the file
		// file.length returns long which is cast to int
		byte[] bArray = new byte[(int) file.length()];
		try {
			fis = new FileInputStream(file);
			fis.read(bArray);
			fis.close();

		} catch (IOException ioExp) {
			ioExp.printStackTrace();
		}
		return bArray;
	}

}
