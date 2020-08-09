package com.goapps.midday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goapps.midday.entity.ClassEntity;
import com.goapps.midday.entity.SchoolEntity;
import com.goapps.midday.entity.SectionEntity;
import com.goapps.midday.entity.SystemSourceEntity;

@Repository
public interface SectionRepository extends CrudRepository<SectionEntity, Long> {
	
	@Query("SELECT u FROM SectionEntity u WHERE u.classId = :classId")
	public List<SectionEntity> getAllSection(@Param("classId") Long classId);
}
