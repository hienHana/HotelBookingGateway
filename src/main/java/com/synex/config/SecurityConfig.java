package com.synex.config;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder bCryptpeasswordEncoder;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).<your password>Encoder(bCryptpeasswordEncoder);
	}
	
	
	protected void configure(HttpSecurity hts) throws Exception {		
		
		
		hts.authorizeRequests().antMatchers(
				 "/getUserSignUpForm","/createUser",
				"/getGuestDetailForm","/createGuestDetail",
				 "/getAllHotels","/getHotels","/getRoomsByHotelId/{hotelIdSel}",
				 "/home","/").permitAll();
		hts.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().logoutSuccessUrl("/login?logout")
		.and()
		.exceptionHandling().accessDeniedPage("/accessDeniedPage")
		.and()
		.httpBasic().disable(); //disable browser login
		
		hts.csrf().disable();
	}
	
	public void configure(WebSecurity webs) {
		webs.ignoring().antMatchers("/images/*","/css/*","/js/*");
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptpeasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}

