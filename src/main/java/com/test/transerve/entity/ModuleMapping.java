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
@Table(name = "tbl_module_mapping")
public class ModuleMapping implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7355094522469533165L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mapping_id")
	private Long mappingId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "module_id")
	private Module moduleId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_id")
	private UserDetail assignedId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_by")
	private UserDetail assignedBy;
	@Column(name = "assigned_date")
	private LocalDate assignedDate;
	@Column(name = "is_active")
	private Byte isActive;//0-actvice,1-deactive

	public Long getMappingId() {
		return mappingId;
	}

	public void setMappingId(Long mappingId) {
		this.mappingId = mappingId;
	}

	public Module getModuleId() {
		return moduleId;
	}

	public void setModuleId(Module moduleId) {
		this.moduleId = moduleId;
	}

	public UserDetail getAssignedId() {
		return assignedId;
	}

	public void setAssignedId(UserDetail assignedId) {
		this.assignedId = assignedId;
	}

	public UserDetail getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(UserDetail assignedBy) {
		this.assignedBy = assignedBy;
	}

	public LocalDate getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDate assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

}
