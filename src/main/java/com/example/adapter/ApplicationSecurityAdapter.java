package com.example.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;




@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurityAdapter extends WebSecurityConfigurerAdapter {
 @Value("${application.username}")
 private String username;
 @Value("${application.password}")
 private String password;
 @Override
 public void configure(WebSecurity web) throws Exception {
  //  web.ignoring().antMatchers("/api/addStudentDetails");
  // web.ignoring().antMatchers("/api/getStudentInfoByName/{name}");
  // web.ignoring().antMatchers("/api/getStudentInfoById/{id}");
  //web.ignoring().antMatchers("/api/getStudentInfoByLastName/{name}");
 }
 private static String REALM = "MY_TEST_REALM";

 @Autowired
 public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
  auth.inMemoryAuthentication().withUser(username).password(password).roles("ADMIN");
 }

 @Override
 protected void configure(HttpSecurity http) throws Exception {

  http.csrf().disable().cors().and()
   .authorizeRequests()
   .antMatchers("/token").hasRole("ADMIN")
   .antMatchers("/api/addStudentDetails").hasRole("ADMIN")
   .antMatchers("/api/getStudentInfoByName/{name}").hasRole("ADMIN")
   .antMatchers("/api/getStudentInfoById").hasRole("ADMIN")
   .antMatchers("/api/getStudentInfoByclassDetails/{class}").hasRole("ADMIN")
   .antMatchers("/api/deleteById/{id}").hasRole("ADMIN")
   .antMatchers("/api/updateByData").hasRole("ADMIN")
   .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint());
  http.sessionManagement()
   .sessionFixation().migrateSession()
   .invalidSessionUrl("/")
   .maximumSessions(1)
   .maxSessionsPreventsLogin(false)
   .expiredUrl("/login");
 }

 @Bean
 public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
  return new CustomBasicAuthenticationEntryPoint();
 }

 @Bean
 public HttpSessionStrategy httpSessionStrategy() {
  return new HeaderHttpSessionStrategy();
 }


}