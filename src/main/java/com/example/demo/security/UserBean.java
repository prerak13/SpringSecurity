package com.example.demo.security;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserBean {
	@Id
	public Integer id;
	public String uname;
	public String pwd;
	public String authority;
	public Boolean active;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String role) {
		this.authority = role;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
