package com.test.transerve.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.transerve.entity.Role;

public interface RoleRepo extends CrudRepository<Role, Integer> {
	
}
