package com.codevita.lankaoffers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.codevita.lankaoffers.util.AppConstants;

@Configuration 
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
// configure AuthenticationManager so that it knows from where to load
// user for matching credentials
// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable()
		.authorizeRequests()
		.antMatchers("/v2/api-docs", "/configuatration/**","/swagger*/**","/webjars/**").permitAll()
		
		.antMatchers(HttpMethod.POST, AppConstants.BASE_URL + AppConstants.USERS_SIGN_IN).permitAll()
		.antMatchers(HttpMethod.POST, AppConstants.BASE_URL + AppConstants.PUBLIC_GUESTS_SIGN_UP).permitAll()
		.antMatchers(HttpMethod.POST, AppConstants.BASE_URL + AppConstants.COMPANY_SIGN_UP).permitAll()
		
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + (AppConstants.POST_URL)).permitAll()

		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.DEALS_OF_THE_DAY).permitAll()
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.POPULAR_POST).permitAll()
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.POST_BY_CREATE_DATE).permitAll()

		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.POST_CATEGORY_URL).permitAll()
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.POST_CATEGORY_BY_ID_URL).permitAll()
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.POST_COUNT_BY_POST_CATARGORIES).permitAll()
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.POST_BY_POST_CATARGORIES).permitAll()
		
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.POST_COUNT_BY_COMPANIES).permitAll()
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.POST_BY_COMPANIES).permitAll()
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.COMPANY_URL).permitAll()
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.COMPANY_BY_ID_URL).permitAll()
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.COMPANY_CREATED_DATEWISE).permitAll()
		
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + AppConstants.POST_VIEW_URL).permitAll()
		.antMatchers(HttpMethod.GET, AppConstants.BASE_URL + (AppConstants.POST_VIEW_BY_ID_URL)).permitAll()
		.antMatchers(HttpMethod.POST, AppConstants.BASE_URL + AppConstants.POST_VIEW_URL).permitAll()
		
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher(AppConstants.BASE_URL + AppConstants.ACTIVITYlOG_BY_ID_URL))
		.logoutSuccessUrl(AppConstants.BASE_URL + AppConstants.ACTIVITYlOG_BY_ID_URL)
		.and()
		.rememberMe().tokenValiditySeconds(2592000).key("mySecret!")
	    .and()
	    .sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
		.authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
		// Let Spring decide filter sequence to execute. Done by extending abstract
		// classes
		.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		httpSecurity.headers().cacheControl();
		
	}

}
