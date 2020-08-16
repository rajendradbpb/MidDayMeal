package com.goapps.midday.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goapps.midday.entity.AttendanceEntity;
import com.goapps.midday.entity.MealEntity;

@Repository
public interface AttendanceRepository extends CrudRepository<AttendanceEntity, Long> {
	public List<AttendanceEntity> findByMealIdAndSchoolIdAndUserIdIn(Long mealId, Long schoolId, List<Long> userId);
}
