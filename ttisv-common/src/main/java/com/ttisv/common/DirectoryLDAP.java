package com.ttisv.common;
import java.util.Enumeration;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
public class DirectoryLDAP {
	public void doLookup() {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		properties.put(Context.PROVIDER_URL, "ldap://10.0.58.101:389");
		properties.put(Context.SECURITY_AUTHENTICATION,"simple");
		properties.put(Context.SECURITY_PRINCIPAL,"test\\b2b-user1"); 
		properties.put(Context.SECURITY_CREDENTIALS,"Agribank@123");
		try {
			DirContext context = new InitialDirContext(properties);
			SearchControls searchCtrls = new SearchControls();
			searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String filter = "(objectClass=*)";
			//NamingEnumeration values = context.search("DC=test,DC=agri,DC=com,DC=vn",filter,searchCtrls);
			NamingEnumeration values = context.search("CN=b2b-user5,OU=API-B2B,DC=test,DC=agri,DC=com,DC=vn",filter,searchCtrls);
			
			
			while (values.hasMoreElements())
			{
				SearchResult result = (SearchResult) values.next();
				Attributes attribs = result.getAttributes();

				if (null != attribs)
				{
					for (NamingEnumeration ae = attribs.getAll(); ae.hasMoreElements();)
					{
						Attribute atr = (Attribute) ae.next();
						String attributeID = atr.getID();
						Enumeration vals = atr.getAll(); 
						while (vals.hasMoreElements()) {
							//while (vals.hasMoreElements()&&attributeID.equals("name")) {
				            // get elements using nextElement()
							//if( vals.nextElement().toString().equals("b2b-user1"))
							System.out.println(attributeID +": "+ vals.nextElement());
				        }
					
					
					}
				}
			}

			context.close();

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DirectoryLDAP sample = new DirectoryLDAP();
		sample.doLookup();
	}
}
