package com.cetpa.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cetpa.entities.User;
import com.cetpa.entities.UserRole;

public class UserDetailsImpl implements UserDetails 
{
	private User user;
	public UserDetailsImpl(User user)
	{
		System.out.println("Object of userdetails created...");
		this.user=user;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		List<UserRole> roles=user.getRoleList();
		/*List<GrantedAuthority> list=new ArrayList<>();
		for(UserRole role:roles)
		{
			list.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
		}
		return list;*/
		return roles.stream().map(role->new SimpleGrantedAuthority("ROLE_"+role.getRole())).collect(Collectors.toList()); 
	}
	public String getPassword() 
	{
		return user.getPassword();
	}
	public String getUsername() 
	{
		return user.getUsername();
	}
	public boolean isAccountNonExpired() 
	{
		return user.isAccountNonExprired();
	}
	public boolean isAccountNonLocked() 
	{
		return user.isAccountNonLocked();
	}
	public boolean isCredentialsNonExpired() 
	{
		return user.isCredentialNonExprired();
	}
	public boolean isEnabled() 
	{
		return user.isEnabled();
	}
}
