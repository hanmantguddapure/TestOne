package com.test.transerve.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.transerve.entity.UserDetail;

public interface UserDetailRepo extends CrudRepository<UserDetail, Long> {
	public UserDetail findByFullName(String fullName);

}
