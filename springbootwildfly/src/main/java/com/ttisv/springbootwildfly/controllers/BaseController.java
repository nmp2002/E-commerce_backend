package com.ttisv.springbootwildfly.controllers;

import java.nio.charset.StandardCharsets;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ttisv.common.utils.Base64Utils;
import com.ttisv.springbootwildfly.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class BaseController {
	protected Gson gson = new GsonBuilder().setPrettyPrinting().create();

	protected UserDetailsImpl getUserInfo() {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			if (authentication == null || authentication.getPrincipal() == null) {
				return null;
			}
			
			Object principal = authentication.getPrincipal();
			
			// Kiểm tra nếu principal là UserDetailsImpl
			if (principal instanceof UserDetailsImpl) {
				UserDetailsImpl userToken = (UserDetailsImpl) principal;
				String name = userToken.getUsername();
				
				byte[] data = Base64Utils.base64Decode(name);
				name = new String(data, StandardCharsets.UTF_8);
				userToken = gson.fromJson(name, UserDetailsImpl.class);
				return userToken;
			}
			
			// Nếu không phải UserDetailsImpl, trả về null hoặc tạo object mặc định
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected String getCurrentUsername() {
		try {
			UserDetailsImpl userToken = getUserInfo();
			if (userToken != null) {
				return userToken.getUsername();
			}
			return "system"; // Default username
		} catch (Exception e) {
			e.printStackTrace();
			return "system"; // Default username
		}
	}
}
