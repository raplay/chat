package com.lrwin.config;

import com.lrwin.dao.AccountDao;
import com.lrwin.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;

/**
 * Created by dulei on 1/16/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccountDao accountDao;

	private static final String SECURE_ADMIN_PASSWORD = "rockandroll";


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
//		http.authorizeRequests().anyRequest().authenticated();
//		http
//				.csrf().disable()
//			.formLogin()
//				.loginPage("/index.html")
//				.defaultSuccessUrl("/chat.html")
//				.permitAll()
//				.and()
//			.logout()
//				.logoutSuccessUrl("/index.html")
//				.permitAll()
//				.and()
//			.authorizeRequests()
//				.antMatchers("/js/**", "/lib/**", "/images/**", "/css/**", "/index.html", "/").permitAll()
//				.antMatchers("/websocket").hasRole("ADMIN")
//				.anyRequest().authenticated();
				
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		UserDetailsManagerConfigurer.UserDetailsBuilder userDetailsBuilder = auth.inMemoryAuthentication()
				.withUser("lrwin").password("lrwin").roles("ADMIN");
		List<Account> accountList = accountDao.findAll();
		for (Account account: accountList){
			userDetailsBuilder.and().withUser(account.getEmail()).password(account.getPasswd()).roles("USER");
		}

//		auth.authenticationProvider(new AuthenticationProvider() {
//
//			@Override
//			public boolean supports(Class<?> authentication) {
//				return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//			}
//
//			@Override
//			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//				UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
//
//				List<GrantedAuthority> authorities = SECURE_ADMIN_PASSWORD.equals(token.getCredentials()) ?
//														AuthorityUtils.createAuthorityList("ROLE_ADMIN") : null;
//
//				return new UsernamePasswordAuthenticationToken(token.getName(), token.getCredentials(), authorities);
//			}
//		});
	}
}
