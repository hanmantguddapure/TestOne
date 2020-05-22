package com.test.transerve.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.transerve.dto.AssignModuleDto;
import com.test.transerve.dto.AuthDetailsDto;
import com.test.transerve.dto.UserDetailDto;
import com.test.transerve.entity.Module;
import com.test.transerve.entity.ModuleMapping;
import com.test.transerve.entity.UserCredential;
import com.test.transerve.entity.UserDetail;
import com.test.transerve.exception.RecordNotFound;
import com.test.transerve.repository.RepositoryManager;
import com.test.transerve.service.UserService;

@Service
public class UserServiceImpl extends RepositoryManager implements UserService {
	private final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public UserDetailDto saveOrUpdate(UserDetailDto userDetailDto) throws Exception {
		logger.info(":creating/updating user");
		UserDetail userDetail = null;

		if (null != userDetailDto.getDob() && userDetailDto.getIsEdit() == 1)
			userDetail = this.getUserDetailRepo().findByFullName(userDetailDto.getFullName());
		else {
			userDetail = new UserDetail();
			userDetail.setCreatedDate(LocalDate.now());
		}
		if (null == userDetail)
			throw new RecordNotFound("user not exist");
		userDetail.setFullName(userDetailDto.getFullName());
		if (null != userDetailDto.getDob() && !userDetailDto.getDob().trim().isEmpty())
			userDetail.setDob(LocalDate.parse(userDetailDto.getDob()));
		if (null != userDetailDto.getGender())
			userDetail.setGender(userDetailDto.getGender());
		userDetail = this.getUserDetailRepo().save(userDetail);
		if (null != userDetail.getUserID()) {
			userDetailDto.setStatusCode(HttpStatus.OK.value());
			userDetailDto.setMsg("success");
		}
		return userDetailDto;

	}

	@Override
	public List<UserDetail> getAllUsers() {
		return (List<UserDetail>) this.getUserDetailRepo().findAll();
	}

	@Override
	public AuthDetailsDto authUser(AuthDetailsDto authDetailsDto) throws Exception {
		logger.info(": authonicate user");
		UserCredential credential = null;
		Map<Long, String> userModules = null;
		List<ModuleMapping> moduleMappings = null;
		credential = this.getUserCredentialRepo().findUserByUserName(authDetailsDto.getUserName());
		if (null == credential)
			authDetailsDto.setMsg("Invalid credentials");
		if (authDetailsDto.getPassword().equalsIgnoreCase(credential.getPassword())) {
			authDetailsDto.setMsg("loggin successfull");
			moduleMappings = this.getModuleMappingRepo().findByAssignedId(credential.getUserId());
			if (null != moduleMappings && moduleMappings.size() > 0)
				userModules = moduleMappings.stream().collect(
						Collectors.toMap(ModuleMapping::getMappingId, obj -> obj.getModuleId().getModuleName()));
			if (null != userModules)
				authDetailsDto.setUserModules(userModules);

		} else
			authDetailsDto.setMsg("Invalid credentials");
		return authDetailsDto;

	}

	@Override
	public AssignModuleDto assignModule(AssignModuleDto assignModuleDto) throws Exception {
		logger.info(":user assign process begins");
		Optional<UserDetail> assignId = null;
		Optional<UserDetail> assignedBy = null;
		Optional<Module> module = null;
		ModuleMapping moduleMapping = null;
		assignId = this.getUserDetailRepo().findById(assignModuleDto.getAssigneId());
		if (!assignId.isPresent()) {
			assignModuleDto.setMsg("assign user not found");
			return assignModuleDto;
		}
		assignedBy = this.getUserDetailRepo().findById(assignModuleDto.getAssignedBy());
		module = this.getModuleRepo().findById(assignModuleDto.getModuleId());
		moduleMapping = this.getModuleMappingRepo().findByModuleIdAndAssignedId(module.get(), assignId.get());
		if (null == moduleMapping)
			moduleMapping = new ModuleMapping();
		if (assignModuleDto.getAssigneType() == 2)
			moduleMapping.setIsActive((byte) 1);
		else
			moduleMapping.setIsActive((byte) 0);
		moduleMapping.setAssignedDate(LocalDate.now());
		moduleMapping.setAssignedId(assignId.get());
		moduleMapping.setAssignedBy(assignedBy.get());
		moduleMapping.setModuleId(module.get());
		moduleMapping = this.getModuleMappingRepo().save(moduleMapping);
		assignModuleDto.setMsg("Assigned Successfully");
		return assignModuleDto;
	}

	@Override
	public List<UserDetailDto> getAllUserModules() throws Exception {
		logger.info(": Fetching Users");
		List<UserDetail> userDetails = null;
		List<UserDetailDto> userDetailDtos = null;
		userDetails = (List<UserDetail>) this.getUserDetailRepo().findAll();
		if (null != userDetails && userDetails.size() > 0) {
			userDetailDtos = userDetails.stream().map(dataObj -> {
				UserDetailDto userDetailDto = new UserDetailDto();
				userDetailDto.setFullName(dataObj.getFullName());
				if (null != dataObj.getRoleId())
					userDetailDto.setRoleId(dataObj.getRoleId().getRoleId());
				userDetailDto.setUserId(dataObj.getUserID());
				List<ModuleMapping> moduleMappings = this.getModuleMappingRepo().findByAssignedId(dataObj);
				if (null != moduleMappings && moduleMappings.size() > 0) {
					Map<Long, String> userModules = moduleMappings.stream().collect(
							Collectors.toMap(ModuleMapping::getMappingId, obj -> obj.getModuleId().getModuleName()));
					if (null != userModules && userModules.size() > 0)
						userDetailDto.setUserModules(userModules);
				}
				return userDetailDto;
			}).collect(Collectors.toList());
		}

		return userDetailDtos;

	}

}
