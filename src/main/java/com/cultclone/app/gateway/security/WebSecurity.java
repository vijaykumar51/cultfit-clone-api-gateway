package com.cultclone.app.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * The Class WebSecurity.
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	/** The env. */
	@Autowired
	private Environment env;

	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/home").permitAll()
				.antMatchers("/cult-account-ws/api/auth/get-token").permitAll()
				.antMatchers(HttpMethod.POST, "/cult-account-ws/api/user").permitAll().and()
				.addFilter(new JwtAuthorizationFilter(authenticationManager(), env));

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
