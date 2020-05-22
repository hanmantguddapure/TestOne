package com.test.transerve.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user_credential")
public class UserCredential {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "credential_Id")
	private Long credentialId;
	@Column(name = "userName", length = 20, unique = true)
	private String userName;
	@Column(name = "password")
	private String password;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private UserDetail userId;
	private LocalDateTime lastLoginTime;

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

	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(LocalDateTime lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Long credentialId) {
		this.credentialId = credentialId;
	}

	public UserDetail getUserId() {
		return userId;
	}

	public void setUserId(UserDetail userId) {
		this.userId = userId;
	}

}