package com.doctorplus.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class User implements UserDetails {

	private static final long serialVersionUID = 8376351862792922926L;

	String id;
	String username;
	String password;

	@JsonCreator
	public User(@JsonProperty("id") final String id, @JsonProperty("username") final String username,
			@JsonProperty("password") final String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@JsonIgnore
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
	
	public String getId() {
		return this.id;
	}

}
