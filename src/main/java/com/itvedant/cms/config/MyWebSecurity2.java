package com.itvedant.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class MyWebSecurity2
{
//Authentication
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("Alice")
//		.password("Alice123") // cleartext
//	    .authorities("ADMIN")
//	    .and()
//	    .withUser("Benn")
//	    .password("Benn123")   // cleartext
//		.authorities("USER");
		
//		auth.authenticationProvider(myAuthenticationProvider());
		
//	}

@Bean
public AuthenticationProvider myAuthenticationProvider() {
	DaoAuthenticationProvider daoProvider=new DaoAuthenticationProvider();
	daoProvider.setUserDetailsService(mySetUserDetailsService());
	daoProvider.setPasswordEncoder(mySetPasswordEncoder());
	return daoProvider;
}

@Bean
public PasswordEncoder mySetPasswordEncoder() {
	return new BCryptPasswordEncoder();
}

@Bean
public UserDetailsService mySetUserDetailsService() {
	return new MySetUserDetailsServiceNew();
}

//	@Bean
// 	public PasswordEncoder getPasswordEncoder()
// 	{
// 		return NoOpPasswordEncoder.getInstance();
// 	}


//Authorisation
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//        .antMatchers("/home","/registerCustomer","/403").hasAnyAuthority("USER","ADMIN")
//        .antMatchers("/deleteCustomer/**","/updateCustomerForm/**").hasAuthority("ADMIN")
//        .anyRequest().authenticated()
//        .and()
//        .formLogin().loginProcessingUrl("/login").successForwardUrl("/home").permitAll()
//        .and()
//        .logout().logoutSuccessUrl("/login").permitAll()
//        .and()
//        .exceptionHandling().accessDeniedPage("/403")
//        .and()
//        .cors().and().csrf().disable();
//
//	}


@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  
   http.authorizeRequests()
  .antMatchers("/home","/registerCustomer","/403").hasAnyAuthority("USER","ADMIN")
  .antMatchers("/deleteCustomer/**","/updateCustomerForm/**").hasAuthority("ADMIN")
  .anyRequest().authenticated()
  .and()
  .formLogin().loginProcessingUrl("/login").successForwardUrl("/home").permitAll()
  .and()
  .logout().logoutSuccessUrl("/login").permitAll()
  .and()
  .exceptionHandling().accessDeniedPage("/403")
  .and()
  .cors().and().csrf().disable();
   
   http.authenticationProvider(myAuthenticationProvider());
   
    return http.build();
}
}
