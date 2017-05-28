package tn.tcon.tenancy.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import tn.tcon.tenancy.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http.authorizeRequests().antMatchers("/admin/**")
		// .access("hasRole('ROLE_ADMIN')").and().formLogin()
		// .loginPage("/loginPage").failureUrl("/loginPage?error")
		// .usernameParameter("username")
		// .passwordParameter("password")
		// .and().logout().logoutSuccessUrl("/loginPage?logout")
		// .and().csrf()
		// .and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests().antMatchers("/homePage").access("hasRole('ROLE_USER')").and().formLogin()
				.loginPage("/loginPage").defaultSuccessUrl("/homePage").failureUrl("/loginPage?error")
				.usernameParameter("username").passwordParameter("password").and().logout()
				.logoutSuccessUrl("/loginPage?logout");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder
	// authenticationMgr) throws Exception {
	// authenticationMgr.inMemoryAuthentication()
	// .withUser("kadhem")
	// .password("kacem")
	// .authorities("ROLE_USER");
	// }
	//
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests()
	// .antMatchers("/homePage").access("hasRole('ROLE_USER')")
	// .and()
	// .formLogin().loginPage("/loginPage")
	// .defaultSuccessUrl("/homePage")
	// .failureUrl("/loginPage?error")
	// .usernameParameter("username").passwordParameter("password")
	// .and()
	// .logout().logoutSuccessUrl("/loginPage?logout");
	//
	// }
}