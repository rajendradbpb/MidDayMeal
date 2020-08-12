package com.goapps.midday.repository.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goapps.midday.entity.UserEntity;
import com.goapps.midday.valueobject.user.UserCount;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
	
}
