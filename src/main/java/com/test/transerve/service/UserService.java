package com.test.transerve.service;

import java.util.List;

import com.test.transerve.dto.AssignModuleDto;
import com.test.transerve.dto.AuthDetailsDto;
import com.test.transerve.dto.UserDetailDto;
import com.test.transerve.entity.UserDetail;

public interface UserService {
	public UserDetailDto saveOrUpdate(UserDetailDto userDetailDto) throws Exception;

	public AuthDetailsDto authUser(AuthDetailsDto authDetailsDto) throws Exception;

	public AssignModuleDto assignModule(AssignModuleDto assignModuleDto) throws Exception;

	public List<UserDetail> getAllUsers();

	public List<UserDetailDto> getAllUserModules() throws Exception;

}
