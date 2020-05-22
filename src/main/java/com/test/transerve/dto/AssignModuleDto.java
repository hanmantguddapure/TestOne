package com.test.transerve.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class AssignModuleDto extends ErrorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6748270934789369146L;
	@NotNull(message = "moduleId May Not Be Empty")
	private Integer moduleId;
	@NotNull(message = "assigneId May Not Be Empty")
	private Long assigneId;
	@NotNull(message = "assignedBy May Not Be Empty")
	private Long assignedBy;
	@NotNull(message = "assigneType May Not Be Empty")
	private Byte assigneType;// 1-new assign,2-remove assign,3-update

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Long getAssigneId() {
		return assigneId;
	}

	public void setAssigneId(Long assigneId) {
		this.assigneId = assigneId;
	}

	public Long getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(Long assignedBy) {
		this.assignedBy = assignedBy;
	}

	public Byte getAssigneType() {
		return assigneType;
	}

	public void setAssigneType(Byte assigneType) {
		this.assigneType = assigneType;
	}

}
