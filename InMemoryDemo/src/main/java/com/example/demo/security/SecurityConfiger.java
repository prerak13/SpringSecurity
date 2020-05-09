package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class SecurityConfiger extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource ds;
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.jdbcAuthentication()
	.dataSource(ds);
}

@Bean
public PasswordEncoder func() {
	return NoOpPasswordEncoder.getInstance();//sngleton pattern
}


@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http);
		http.authorizeRequests()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/user").hasAnyAuthority("USER","ADMIN")
		.antMatchers("/").permitAll()
		.and().formLogin().and().csrf().disable();
	}
}
