package com.test.transerve.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_module")
public class Module implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3446132869307052816L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="module_id")
	private Integer moduleId;
	@Column(name="module_name")
	private String moduleName;
	@Column(name="description")
	private String description;
	@Column(name="is_active")
	private Byte isActive;
	@Column(name="created_date")
	private LocalDate createdDate;
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Byte getIsActive() {
		return isActive;
	}
	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	

}
