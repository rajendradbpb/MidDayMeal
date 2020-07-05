package com.goapps.midday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goapps.midday.entity.SystemSourceEntity;

@Repository
public interface SystemSourceRepository extends CrudRepository<SystemSourceEntity, Long> {
	public List<SystemSourceEntity> findBycPurpose(String cPurpose);
	@Query("SELECT u FROM SystemSourceEntity u WHERE u.cPurpose = :cPurpose and u.iIdParent = :iIdParent")
	public List<SystemSourceEntity> findBycPurposeAndiIdParent(@Param("cPurpose") String cPurpose, @Param("iIdParent") Long iIdParent);
}
