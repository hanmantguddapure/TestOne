package com.test.transerve.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.transerve.entity.UserCredential;

public interface UserCredentialRepo extends CrudRepository<UserCredential, Long> {
	public UserCredential findUserByUserName(String username);

}
