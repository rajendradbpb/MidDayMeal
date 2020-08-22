package com.goapps.midday.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goapps.midday.entity.SchoolEntity;

@Repository
public interface SchoolRepository extends CrudRepository<SchoolEntity, Long> {
	public SchoolEntity findSchoolByName(String schoolName);
}
