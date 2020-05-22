package com.test.transerve.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AuthDetailsDto extends ErrorDto implements Serializable {

	private static final long serialVersionUID = -1014193388339967757L;
	@NotBlank(message = "userName May Not Be Empty")
	@NotNull(message = "userName May Not Be Empty")
	private String userName;
	@NotBlank(message = "password May Not Be Empty")
	@NotNull(message = "password May Not Be Empty")
	private String password;
	private String fullName;
	private Integer roleId;
	private Long userId;
	Map<Long, String> userModules = new HashMap<>();
	private String loggedInUserIpAddress;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoggedInUserIpAddress() {
		return loggedInUserIpAddress;
	}

	public void setLoggedInUserIpAddress(String loggedInUserIpAddress) {
		this.loggedInUserIpAddress = loggedInUserIpAddress;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Map<Long, String> getUserModules() {
		return userModules;
	}

	public void setUserModules(Map<Long, String> userModules) {
		this.userModules = userModules;
	}

}
