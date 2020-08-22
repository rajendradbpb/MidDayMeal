package com.goapps.midday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goapps.midday.entity.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
	@Query("SELECT u FROM RoleEntity u WHERE u.name = :roleName")
	public List<RoleEntity> getRoleByName(@Param("roleName") String roleName);
}
