package com.goapps.midday.service;

import java.util.ArrayList;
import java.util.List;
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
import com.goapps.midday.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	MessageConfiguration messageConfig;

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
		return userRepository.findById(id).get();
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

	
	public boolean validateUserData(UserEntity user) throws InvalidRequestException{
		if(user.getRollId() == 0) {
			throw new InvalidRequestException(messageConfig.getUserMessage().getRollIdRequired());
		}
		if(user.getSchoolId() == 0) {
			throw new InvalidRequestException(messageConfig.getUserMessage().getSchoolIdRequired());
		}
		// check for role
		if(
				!(roleRepository.findById(user.getRollId()).get().getName().equals(AppConstants.ROLE_STUDENT)
				|| roleRepository.findById(user.getRollId()).get().getName().equals(AppConstants.ROLE_COOK) )
				&& user.getPassword() == null
				) {
			throw new InvalidRequestException(messageConfig.getUserMessage().getPasswordRequired());
		}
		return true;
	}

}
