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

import com.goapps.midday.entity.SchoolEntity;
import com.goapps.midday.entity.UserEntity;
import com.goapps.midday.repository.SchoolRepository;
import com.goapps.midday.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

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


}
