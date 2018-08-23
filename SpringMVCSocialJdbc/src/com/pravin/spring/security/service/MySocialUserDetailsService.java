package com.pravin.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import com.pravin.spring.secuity.dao.MyUserAccountDAO;
import com.pravin.spring.secuity.model.MyUserAccount;
import com.pravin.spring.security.user.MySocialUserDetails;

@Service
public class MySocialUserDetailsService implements SocialUserDetailsService {

    @Autowired
    private MyUserAccountDAO myUserAccountDAO;

    // Loads the UserDetails by using the userID of the user.
    // (This method Is used by Spring Security API).
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {

	MyUserAccount account = myUserAccountDAO.findById(userId);

	MySocialUserDetails userDetails = new MySocialUserDetails(account);

	return userDetails;
    }
}
