package com.goapps.midday.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Priority(value = 1)
public class ApiValidatorFilter implements Filter {

	Logger LOG = LoggerFactory.getLogger(ApiValidatorFilter.class);
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        LOG.info("request.getPathInfo() "+ httpServletRequest.getRequestURI());
		LOG.info("request.getPathInfo() "+ httpServletRequest.getMethod());
		
		/*
		 * LOG.info("request.path "+
		 * httpServletRequest.getContextPath()+"\n"+httpServletRequest.getLocalAddr()
		 * +"\n"+httpServletRequest.getLocalName()+"\n"+httpServletRequest.getLocalPort(
		 * )+"\n"+httpServletRequest.getProtocol()
		 * +"\n"+httpServletRequest.getRequestURI()+"\n"+httpServletRequest.
		 * getRequestURL()+"\n"+
		 * httpServletRequest.getScheme()+"\n"+httpServletRequest.getServerName()+"\n"+
		 * httpServletRequest.getServerPort());
		 */
		chain.doFilter(request, response);
	}

	

}
