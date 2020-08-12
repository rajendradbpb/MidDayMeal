package com.goapps.midday.repository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.goapps.midday.entity.UserEntity;
import com.goapps.midday.valueobject.user.UserCount;

public interface IUserDao  {
	List<UserCount> getUserCounts(Long SchoolId);
	
	List<UserEntity> getUserByRoleAndSchoolId(Long schoolId,String role);

}
