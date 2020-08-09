package com.goapps.midday.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.goapps.midday.service.UserService;
import com.goapps.midday.utitlity.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserService userDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = null;
		String userName = null;
		String authorizationHeader = request.getHeader("Authorization");
		// Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYXZhMSIsImV4cCI6MTU5NjkxMzk4MiwiaWF0IjoxNTk2ODc3OTgyfQ.j5iUAGKMknl-0F40xuLHQXzJzKGFbKNwSrkKpMhSOYQ
		if (null != authorizationHeader && authorizationHeader.startsWith("Bearer")) {
			token = authorizationHeader.substring(7);
			userName = jwtUtil.extractUsername(token);
		}
		if (null != userName && null == SecurityContextHolder.getContext().getAuthentication()) {
			UserDetails userDetails = userDetailService.loadUserByUsername(userName);
			if (jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		filterChain.doFilter(request, response);
	}

}
