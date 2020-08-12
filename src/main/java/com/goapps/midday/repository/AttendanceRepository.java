package com.goapps.midday.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goapps.midday.entity.AttendanceEntity;
import com.goapps.midday.entity.MealEntity;

@Repository
public interface AttendanceRepository extends CrudRepository<AttendanceEntity, Long> {
	
}
