package com.ttisv.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XslUtils {
	public static String getTransformedHtml(byte[] xlsContent, byte[] xmlContent) throws TransformerException {
		StringWriter writer = new StringWriter();
		try {
			String key = "javax.xml.transform.TransformerFactory";
			String value = "org.apache.xalan.processor.TransformerFactoryImpl";
			Properties props = System.getProperties();
			props.put(key, value);
			Properties abc = System.getProperties();
			System.setProperties(props);
//			String strXml = new String(xmlContent, "UTF-8");
//			strXml = strXml.replaceAll("&", "&amp;");
//			strXml = strXml.replaceAll("ns2:", "");
//			strXml = strXml.replaceAll(":ns2", "");
//			if (strXml.indexOf("xmlns=\"http://kekhaithue.gdt.gov.vn/TKhaiThue\"") > 0) {
//				strXml = strXml.replace("xmlns=\"http://kekhaithue.gdt.gov.vn/TKhaiThue\"", "");
//			} else if (strXml.indexOf("xmlns=\"http://kekhaithue.gdt.gov.vn/TBaoThue\"") > 0) {
//				strXml = strXml.replace("xmlns=\"http://kekhaithue.gdt.gov.vn/TBaoThue\"", "");
//			} else if (strXml.indexOf("xmlns=\"http://kekhaithue.gdt.gov.vn/HSoDKy\"") > 0) {
//				strXml = strXml.replace("xmlns=\"http://kekhaithue.gdt.gov.vn/HSoDKy\"", "");
//			}

//			xmlContent = strXml.getBytes("UTF-8");
			StreamSource srcXml = new StreamSource(new ByteArrayInputStream(xmlContent));
			StreamSource srcXsl = new StreamSource(new ByteArrayInputStream(xlsContent));
			Result result = new StreamResult(writer);
			javax.xml.transform.TransformerFactory tFactory = javax.xml.transform.TransformerFactory.newInstance();
			tFactory.setURIResolver(new XsltURIResolver());
			javax.xml.transform.Transformer transformer = tFactory.newTransformer(srcXsl);
			transformer.transform(srcXml, result);
			System.setProperties(abc);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return writer.toString();
	}

	public static byte[] getByteArrayFromFile(String fileName) throws IOException {
		File file;
		FileInputStream fin;
		byte[] fileData;
		file = new File(fileName);
		fin = new FileInputStream(file);
		fileData = new byte[(int) file.length()];
		fin.read(fileData);
		fin.close();
		return fileData;
	}

	public static byte[] getBytes(URL resource) throws IOException {
		InputStream in = resource.openStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		for (int read; (read = in.read(buf)) != -1;) {
			bos.write(buf, 0, read);
		}
		return bos.toByteArray();
	}
}

class XsltURIResolver implements URIResolver {

	@Override
	public Source resolve(String href, String base) throws TransformerException {
		try {
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("xsl/" + href);
			return new StreamSource(inputStream);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}