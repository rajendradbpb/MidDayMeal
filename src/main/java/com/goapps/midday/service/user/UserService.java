package com.goapps.midday.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.goapps.midday.config.AppConstants;
import com.goapps.midday.entity.RoleEntity;
import com.goapps.midday.entity.UserEntity;
import com.goapps.midday.exception.InvalidRequestException;
import com.goapps.midday.mesasge.MessageConfiguration;
import com.goapps.midday.repository.RoleRepository;
import com.goapps.midday.repository.user.IUserDao;
import com.goapps.midday.repository.user.UserRepository;
import com.goapps.midday.valueobject.user.UpdateUserVO;
import com.goapps.midday.valueobject.user.UserCount;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	MessageConfiguration messageConfig;
	
	@Autowired
	IUserDao userDao;

	public UserEntity saveUser(UserEntity userEntity) {
		UserEntity savedData = userRepository.save(userEntity);
		return savedData;
	}

	public List<UserEntity> getAllUser() {
		List<UserEntity> list = StreamSupport.stream(userRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return list;
	}

	public UserEntity getUserById(Long id) {
		UserEntity user = null;
		try {
			Optional<UserEntity>  optional  = userRepository.findById(id);
			user = optional.get();
		} catch (Exception e) {
			throw e;
		}
		return user;
	}
	public UserEntity getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username);
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

	public RoleEntity saveRole(RoleEntity roleEntity) {
		return roleRepository.save(roleEntity);
	}

	public Object getAllRole() {
		List<RoleEntity> roles = StreamSupport.stream(roleRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return roles;
	}

	
	public boolean validateUserData(UserEntity user,String operation) throws InvalidRequestException{
		switch (operation) {
		case "save":
		case "signup":
			if(user.getRoleId() == 0) {
				throw new InvalidRequestException(messageConfig.getUserMessage().getRollIdRequired());
			}
			if(user.getSchoolId() == 0) {
				throw new InvalidRequestException(messageConfig.getUserMessage().getSchoolIdRequired());
			}
			// check for role
			if(
					!(roleRepository.findById(user.getRoleId()).get().getName().equals(AppConstants.ROLE_STUDENT)
					|| roleRepository.findById(user.getRoleId()).get().getName().equals(AppConstants.ROLE_COOK) )
					&& user.getPassword() == null
					) {
				throw new InvalidRequestException(messageConfig.getUserMessage().getPasswordRequired());
			}
			break;
		
		default:
			break;
		}
		
		return true;
	}

	public UserEntity mapUpdatedUserVO(UpdateUserVO updateUserVO,UserEntity userEntity) {
		if(updateUserVO.getFirstName() != null)
			userEntity.setFirstName(updateUserVO.getFirstName());
		
		if(updateUserVO.getMiddleName() != null)
			userEntity.setMiddleName(updateUserVO.getMiddleName());
		
		if(updateUserVO.getLastname() != null)
			userEntity.setLastname(updateUserVO.getLastname());
		
		if(updateUserVO.getEmail() != null)
			userEntity.setEmail(updateUserVO.getEmail());
		
		if(updateUserVO.getPhone() != null)
			userEntity.setPhone(updateUserVO.getPhone());
		
		if(updateUserVO.getAlternatePhone() != null)
			userEntity.setAlternatePhone(updateUserVO.getAlternatePhone());
		
		if(updateUserVO.getFatherName() != null)
			userEntity.setFatherName(updateUserVO.getFatherName());
		
		if(updateUserVO.getMotherName() != null)
			userEntity.setMotherName(updateUserVO.getMotherName());
		
		if(updateUserVO.getParentContactNo() != null)
			userEntity.setParentContactNo(updateUserVO.getParentContactNo());
		
		if(updateUserVO.getBankAccNo() != null)
			userEntity.setBankAccNo(updateUserVO.getBankAccNo());
		
		if(updateUserVO.getIfsc() != null)
			userEntity.setIfsc(updateUserVO.getIfsc());
		
		if(updateUserVO.getPlotNo() != null)
			userEntity.setPlotNo(updateUserVO.getPlotNo());
		if(updateUserVO.getCity() != null)
			userEntity.setCity(updateUserVO.getCity());
		if(updateUserVO.getVillage() != null)
			userEntity.setVillage(updateUserVO.getVillage());
		if(updateUserVO.getStreet() != null)
			userEntity.setStreet(updateUserVO.getStreet());
		if(updateUserVO.getState() != null)
			userEntity.setState(updateUserVO.getState());
		if(updateUserVO.getCountry() != null)
			userEntity.setCountry(updateUserVO.getCountry());
		if(updateUserVO.getDistrict() != null)
			userEntity.setDistrict(updateUserVO.getDistrict());
		
		if(updateUserVO.getPincode() != null)
			userEntity.setPincode(updateUserVO.getPincode());
		
		return userEntity;
	}
	
	public List<UserCount> getUserCounts(Long SchoolId){
		return userDao.getUserCounts(SchoolId);
	}

}
