package com.ttisv.common.utils;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;

@SuppressWarnings("deprecation")
public class ElementUtils {
	
	private static SAXReader reader;
	private static Document document;
	
	private static XStream xstream=null;

	public static String getXMLValuesByXpath(String inXml, String xpath) {
		String strReturn = "";
		try {
			reader = new SAXReader();
			document = reader.read(new StringReader(inXml));
			strReturn = document.selectSingleNode(xpath).getText();
			
		} catch (Exception e) {
			strReturn ="";
		}
		return strReturn;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getXMLListValuesByXpath(String inXml, String xpath) {
		 List<String> lstReturn = new ArrayList<String>();
		try {
			reader = new SAXReader();
			document = reader.read(new StringReader(inXml));
			List<Node> listN = document.selectNodes(xpath);
			
			for(Node n:listN){
				lstReturn.add(n.getText());
			}
			
		} catch (Exception e) {
		}
		return lstReturn;
	}
	
	public static String detachXmlByXpath(String inXml, String xpath) {
		String strReturn = "";
		try {
			reader = new SAXReader();
			document = reader.read(new StringReader(inXml));
			document.selectSingleNode(xpath).detach();
			strReturn = document.asXML();
		} catch (Exception e) {
			strReturn ="";
		}
		return strReturn;
	}
	
	public static String setValueByXpath(String inXml, String xpath,String textNew) {
		String strReturn = "";
		try {
			reader = new SAXReader();
			document = reader.read(new StringReader(inXml));
			document.selectSingleNode(xpath).setText(textNew==null ? "":textNew);
			strReturn = document.asXML();
		} catch (Exception e) {
			strReturn ="";
		}
		return strReturn;
	}

	public static String ObjectToXml(Object objectRequset,Object... obj) {
		xstream = new XStream(new DomDriver());
		xstream.alias(objectRequset.getClass().getSimpleName(),objectRequset.getClass());

		if (obj != null)
			if (obj.length > 0) {
				for(Object o : obj){
					xstream.alias(o.getClass().getSimpleName(),o.getClass());
					xstream.aliasSystemAttribute(null, "class");
				}
			}
		return xstream.toXML(objectRequset);
	}
	
	public static String ObjectToXmlData(Object objectRequset,Object... obj) {
		XmlFriendlyReplacer replacer = new XmlFriendlyReplacer("ddd", "_");
		xstream = new XStream(new DomDriver("UTF-8", replacer));
		xstream.alias("DATA",objectRequset.getClass());
		
		if (obj != null)
			if (obj.length > 0) {
				for(Object o : obj){
					xstream.alias(o.getClass().getSimpleName(),o.getClass());
					xstream.aliasSystemAttribute(null, "class");
				}
			}
		return xstream.toXML(objectRequset);
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Element> GetListElementByXpath(String inXml, String xpath) {
		List<Element> lstE= null;
		try {
			reader = new SAXReader();
			document = reader.read(new StringReader(inXml));
			lstE = ((Element) document.selectSingleNode( xpath )).elements();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstE;
	}
}
