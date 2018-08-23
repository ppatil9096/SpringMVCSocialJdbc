package com.pravin.spring.security.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.pravin.spring.secuity.model.MyUserAccount;
import com.pravin.spring.security.user.MySocialUserDetails;

public class SecurityUtil {
    // Auto login.
    public static void logInUser(MyUserAccount user) {

	MySocialUserDetails userDetails = new MySocialUserDetails(user);

	Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
		userDetails.getAuthorities());
	SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
