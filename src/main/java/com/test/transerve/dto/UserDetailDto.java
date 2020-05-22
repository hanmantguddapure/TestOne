package com.test.transerve.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDetailDto extends ErrorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3706844248697631788L;
	@NotBlank(message = "fullName May Not Be Empty")
	@NotNull(message = "fullName May Not Be Empty")
	private String fullName;
	private String dob;
	private Byte gender;
	private Byte isEdit;
	private Integer roleId;
	private Long userId;
	Map<Long, String> userModules = new HashMap<>();

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Byte getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Byte isEdit) {
		this.isEdit = isEdit;
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

	public Map<Long, String> getUserModules() {
		return userModules;
	}

	public void setUserModules(Map<Long, String> userModules) {
		this.userModules = userModules;
	}

}
