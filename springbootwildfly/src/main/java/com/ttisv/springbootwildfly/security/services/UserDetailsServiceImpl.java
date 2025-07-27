package com.ttisv.springbootwildfly.security.services;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ttisv.bean.Role;
import com.ttisv.bean.system.TblUser;
import com.ttisv.common.utils.Base64Utils;
import com.ttisv.service.system.TblUserService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	TblUserService tblUserService;
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//byte[] data=Base64Utils.base64Decode(username);
		//username=new String(data, StandardCharsets.UTF_8);
		//UserDetailsImpl	userToken=gson.fromJson(username, UserDetailsImpl.class);
		TblUser user = new TblUser();
		user.setUserName(username);
		List<Role> lst = new ArrayList<Role>();
		Role rol = new Role();
		rol.setId((long) 1);
		rol.setName("admin");
		lst.add(rol);
		return UserDetailsImpl.build(user, lst);
		//return userToken;
	}

}
