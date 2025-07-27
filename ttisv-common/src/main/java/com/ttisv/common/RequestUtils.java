package com.ttisv.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

/**
 * @author Handx
 * @version 0.0.1
 * @since 2018/07/24
 *
 *        CLass tien ich
 */

public class RequestUtils {
	
	public static String getClientIP(HttpServletRequest request) {
		try {
			String xfHeader = request.getHeader("X-Forwarded-For");
			if (xfHeader == null) {
				return request.getRemoteAddr();
			}
			return xfHeader.split(",")[0];
		} catch (Exception e) {
			return "127.0.0.1";
		}

	}

	public static void clearSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();

		if (session != null) {

			session.invalidate();
		}

		SecurityContextHolder.clearContext();
	}
	
	public static Map<String, String> createMapSearch(HttpServletRequest request,List<String> lstRequest) {
		Map<String, String> map = new HashMap<String, String>();
		for(String str:lstRequest) {
			map.put(str,!StringUtils.isEmpty(request.getParameter(str) )? request.getParameter(str): null);
		}
		return map;
	}
	
	public static String createUrlSearch(Map<String, String> map,List<String> lstRequest) {
		List<String> arr = new ArrayList<String>();
		for(String str:lstRequest) {
		if (map.get(str) != null && map.get(str) != "") {
			arr.add(str+"=" + map.get(str));
		}
		}
		String AsImplodedString;
		if (arr.size() == 0) {
			AsImplodedString = "";
		} else {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < arr.size(); i++) {
				if (i != 0) {
					sb.append("&");
				}
				sb.append(arr.get(i));
			}
			AsImplodedString = sb.toString();
		}
		return AsImplodedString != "" ? "?" + AsImplodedString : null;
	}
	public static String createLinkSearch(String search,String page) {
		String url="";
			url+=search== null || search.equals("null") ? "?" : search + "&";
			url+="page=";
			url+=page!=null ? page : "1";
			
			return url;
	}
	
	

}
