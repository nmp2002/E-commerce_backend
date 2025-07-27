package com.ttisv.springbootwildfly.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.ttisv.bean.system.TblUser;
import com.ttisv.service.system.TblUserService;
import com.ttisv.springbootwildfly.common.Constants;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

	@Autowired
	TblUserService tblUserService;

	@Autowired
	PasswordEncoder passwordEncoder;

	protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication,
				messages.getMessage("AbstractUserDetailsAuthenticationProvider.onlySupports",
						"Only UsernamePasswordAuthenticationToken is supported"));
		TblUser rootUser = retrieveUser(authentication.getName());
		if (rootUser != null) {
			CustomUserDetails userDetail = CustomUserDetails.build(rootUser);
			if (!userDetail.isEnabled()) {
				throw new DisabledException("Tài khoản đã bị khóa, Xin vui lòng liên hệ Admin !");
			}
			if (!userDetail.isAccountNonLocked()) {
				throw new LockedException(
						"Tài khoản đã bị khóa do đăng nhập sai quá 5 lần, Xin vui lòng liên hệ Admin !");
			}
			String password = authentication.getCredentials().toString();
			if (!passwordEncoder.matches(password, userDetail.getPassword())) {
				rootUser.setCountLogin(rootUser.getCountLogin() == null ? 0 : rootUser.getCountLogin() + 1);
				if (rootUser.getCountLogin() >= 5L) {
					rootUser.setStatus(Constants.STATUS.LOCK);
				}
				tblUserService.saveorUpdate(rootUser);
				throw new BadCredentialsException("Tài khoản hoặc mật khẩu không chính xác !");
			}
			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userDetail,
					authentication.getCredentials(), new ArrayList<>());
			result.setDetails(authentication.getDetails());
			tblUserService.resetLoginTimes(authentication.getName());
			return result;
		} else {
			throw new BadCredentialsException("Tài khoản không tồn tại !");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	private final TblUser retrieveUser(String username) throws AuthenticationException {
		try {
			TblUser loadedUser = tblUserService.getFullByUserName(username, true);
			if (loadedUser == null) {
				throw new InternalAuthenticationServiceException("Tài khoản không tồn tại !");
			} else {
				return loadedUser;
			}
		} catch (UsernameNotFoundException ex) {
			throw ex;
		} catch (InternalAuthenticationServiceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new InternalAuthenticationServiceException(ex.getMessage(), ex);
		}
	}
}
