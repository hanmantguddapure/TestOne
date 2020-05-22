package com.test.transerve.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.transerve.entity.Module;
import com.test.transerve.entity.ModuleMapping;
import com.test.transerve.entity.UserDetail;

public interface ModuleMappingRepo extends CrudRepository<ModuleMapping, Long> {
	List<ModuleMapping> findByAssignedId(UserDetail assignedId);

	ModuleMapping findByModuleIdAndAssignedId(Module moduleId, UserDetail userId);

}
