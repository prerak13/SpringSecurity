package com.example.demo.security;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demoException.RecordNotFoundException;

public class MyUserDetail implements UserDetails{
String username;
String password;
Boolean active;
List<GrantedAuthority> authorities;

	public MyUserDetail(UserBean u) {
		this.username=u.uname;
		this.password=u.pwd;
		this.active=u.active;
		this.authorities=Arrays.stream
				(u.authority.split(","))
				.map(x->new SimpleGrantedAuthority(x))
				.collect(Collectors.toList());
	}
	public MyUserDetail() {
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return "USER";
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
