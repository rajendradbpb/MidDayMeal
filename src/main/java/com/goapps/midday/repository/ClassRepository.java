package com.goapps.midday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goapps.midday.entity.ClassEntity;
import com.goapps.midday.entity.SchoolEntity;
import com.goapps.midday.entity.SystemSourceEntity;

@Repository
public interface ClassRepository extends CrudRepository<ClassEntity, Long> {
	
	@Query("SELECT u FROM ClassEntity u WHERE u.schoolId = :schoolId")
	public List<ClassEntity> getAllClass(@Param("schoolId") Long schoolId);
}
