package com.doctorplus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.doctorplus.controller.GreetingController;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import static org.springframework.http.HttpStatus.FORBIDDEN;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SecurityConfig extends WebSecurityConfiguration {
	
	private static final Logger logger = LogManager.getLogger(SecurityConfig.class);
	
	//private static final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(new AntPathRequestMatcher("/public/**"));
	private static final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(new AntPathRequestMatcher("/greeting"));
	private static final RequestMatcher PROTECTED_URLS = new NegatedRequestMatcher(PUBLIC_URLS);

	TokenAuthenticationProvider provider;

	SecurityConfig(final TokenAuthenticationProvider provider, AuthenticationManager authenticationManager) {
		super();
		this.provider = provider;
	}
	
	@Autowired
	void registerProvider(AuthenticationManagerBuilder auth) {
	    auth.authenticationProvider(provider);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		logger.info("filterChainChtulhu");
	    /*http
	    .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .exceptionHandling()
        .defaultAuthenticationEntryPointFor(forbiddenEntryPoint(), PROTECTED_URLS)
        .and()
        .authenticationProvider(provider)
        .addFilterBefore(restAuthenticationFilter(authenticationManager(http.getSharedObject(AuthenticationConfiguration.class))), AnonymousAuthenticationFilter.class)
        .authorizeHttpRequests()
        .requestMatchers(PROTECTED_URLS)
        .authenticated()
        .and()
        .csrf().disable()
        .formLogin().disable()
        .httpBasic().disable()
        .logout().disable();*/
		
		 http.csrf().disable()
         .authorizeHttpRequests((authorize) ->
                 //authorize.anyRequest().authenticated()
                 authorize.requestMatchers(HttpMethod.GET, "/**").permitAll()
                         //.requestMatchers("/api/auth/**").permitAll()
                         //.anyRequest().authenticated()

         );
	       
	    return http.build();
	}

	@Bean
	private AuthenticationEntryPoint forbiddenEntryPoint() {
		 return new HttpStatusEntryPoint(FORBIDDEN);
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

	@Bean
	  TokenAuthenticationFilter restAuthenticationFilter(AuthenticationManager authenticationManager) throws Exception {
	    final TokenAuthenticationFilter filter = new TokenAuthenticationFilter(PROTECTED_URLS);
	    filter.setAuthenticationManager(authenticationManager);
	    filter.setAuthenticationSuccessHandler(successHandler());
	    return filter;
	  }

	private AuthenticationSuccessHandler successHandler() {
		final SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
	    successHandler.setRedirectStrategy(new NoRedirectStrategy());
	    return successHandler;
	}

}
