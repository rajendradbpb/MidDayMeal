package com.goapps.midday.utitlity;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import com.goapps.midday.entity.UserEntity;
import com.goapps.midday.valueobject.UserRequestVO;

@Component
public class BeanFactory {

	// map one bean to another using dozer
	public UserEntity getUserEntity(UserRequestVO userReq) {
		Mapper mapper = new DozerBeanMapper();

		UserEntity destObject = 
		    mapper.map(userReq, UserEntity.class);
		
		return destObject;
	}
}
