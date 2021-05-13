package com.ust.book.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtFilter extends GenericFilterBean {

	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	
    	HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		final String authHeader = req.getHeader("authorization");
		final String adminHead = req.getHeader("Knock_Knock");
		if ("OPTIONS".equals(req.getMethod())) {
			res.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(req, res);
		} else {
			if (authHeader == null || !authHeader.startsWith("Doom ")) {
				throw new ServletException("Missing or invalid Authorization header");
			}
			else if(adminHead == null){
				throw new ServletException("You are not the Guardian of thees Books");
			}
			final String token = authHeader.substring(5);
			final Claims claims = Jwts.parser().setSigningKey("seceretLock").parseClaimsJws(token).getBody();
			request.setAttribute("claims", claims);
			chain.doFilter(req, res);
		}


    }

}
