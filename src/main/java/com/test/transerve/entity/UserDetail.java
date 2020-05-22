package com.test.transerve.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "tbl_user_detail")
public class UserDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6502820063730597164L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userID;
	@Column(name = "full_name", nullable = false)
	private String fullName;
	@JoinColumn(name = "role_id")
	@OneToOne(fetch = FetchType.EAGER)
	private Role roleId;
	@Column(name = "gender")
	private Byte gender;// 1-male,2-female
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "created_date")
	private LocalDate createdDate;
	@Column(name = "updatedDate")
	private LocalDate updatedDate;
	@Column(name = "is_active")
	private Byte isActice;// 0-active,1-deactive;
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Role getRoleId() {
		return roleId;
	}
	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
	public Byte getGender() {
		return gender;
	}
	public void setGender(Byte gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Byte getIsActice() {
		return isActice;
	}
	public void setIsActice(Byte isActice) {
		this.isActice = isActice;
	}
	

}
