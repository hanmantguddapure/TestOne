package com.test.transerve.repository;

import org.springframework.beans.factory.annotation.Autowired;

public class RepositoryManager {
	@Autowired
	public RoleRepo roleRepo;
	@Autowired
	public UserDetailRepo userDetailRepo;
	@Autowired
	public UserCredentialRepo userCredentialRepo;
	@Autowired
	public ModuleRepo moduleRepo;
	@Autowired
	public ModuleMappingRepo moduleMappingRepo;

	public RoleRepo getRoleRepo() {
		return roleRepo;
	}

	public void setRoleRepo(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}

	public UserDetailRepo getUserDetailRepo() {
		return userDetailRepo;
	}

	public void setUserDetailRepo(UserDetailRepo userDetailRepo) {
		this.userDetailRepo = userDetailRepo;
	}

	public UserCredentialRepo getUserCredentialRepo() {
		return userCredentialRepo;
	}

	public void setUserCredentialRepo(UserCredentialRepo userCredentialRepo) {
		this.userCredentialRepo = userCredentialRepo;
	}

	public ModuleRepo getModuleRepo() {
		return moduleRepo;
	}

	public void setModuleRepo(ModuleRepo moduleRepo) {
		this.moduleRepo = moduleRepo;
	}

	public ModuleMappingRepo getModuleMappingRepo() {
		return moduleMappingRepo;
	}

	public void setModuleMappingRepo(ModuleMappingRepo moduleMappingRepo) {
		this.moduleMappingRepo = moduleMappingRepo;
	}
	

}
