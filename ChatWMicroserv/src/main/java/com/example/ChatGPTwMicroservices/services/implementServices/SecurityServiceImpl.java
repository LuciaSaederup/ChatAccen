package com.example.ChatGPTwMicroservices.services.implementServices;

import com.example.ChatGPTwMicroservices.services.SecurityService;
import com.example.ChatGPTwMicroservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	UserService userService;

	@Autowired
	AuthenticationManager authenticationManger;

	@Override
	public boolean login(String email, String password) {
//		UserDetails userDetails = userService.getUserByEmail(email);
//		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password,
//				userDetails.getAuthorities());
//		authenticationManger.authenticate(token);
//		boolean result = token.isAuthenticated();
//
//		if (result) {
//			SecurityContextHolder.getContext().setAuthentication(token);
//		}
		return true;
	}

}
