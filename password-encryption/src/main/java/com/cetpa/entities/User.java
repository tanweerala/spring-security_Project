package com.cetpa.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User 
{
	@Id
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name="username"),inverseJoinColumns = @JoinColumn(name="rid"))
	private List<UserRole> roleList;
	private boolean accountNonExprired=true;
	private boolean accountNonLocked=true;
	private boolean credentialNonExprired=true;
	private boolean enabled=true;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<UserRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<UserRole> roleList) {
		this.roleList = roleList;
	}
	public boolean isAccountNonExprired() {
		return accountNonExprired;
	}
	public void setAccountNonExprired(boolean accountNonExprired) {
		this.accountNonExprired = accountNonExprired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialNonExprired() {
		return credentialNonExprired;
	}
	public void setCredentialNonExprired(boolean credentialNonExprired) {
		this.credentialNonExprired = credentialNonExprired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
