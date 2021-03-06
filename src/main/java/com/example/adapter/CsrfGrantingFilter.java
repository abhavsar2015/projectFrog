package com.example.adapter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;

public class CsrfGrantingFilter implements Filter {

 @Override
 public void init(FilterConfig filterConfig) throws ServletException {}

 @Override
 public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
 throws IOException, ServletException {
  CsrfToken csrf = (CsrfToken) servletRequest.getAttribute(CsrfToken.class.getName());
  String token = csrf.getToken();
  if (token != null && isAuthenticating(servletRequest)) {
   HttpServletResponse response = (HttpServletResponse) servletResponse;
   Cookie cookie = new Cookie("XSRF-TOKEN", token);
   cookie.setPath("/");
   response.addCookie(cookie);
  }
  filterChain.doFilter(servletRequest, servletResponse);
 }

 private boolean isAuthenticating(ServletRequest servletRequest) {
  HttpServletRequest request = (HttpServletRequest) servletRequest;
  return request.getRequestURI().equals("/api/login");
 }

 @Override
 public void destroy() {}
}