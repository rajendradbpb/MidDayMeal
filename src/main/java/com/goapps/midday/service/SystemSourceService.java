package com.goapps.midday.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goapps.midday.entity.SystemSourceEntity;
import com.goapps.midday.repository.SystemSourceRepository;

@Service
public class SystemSourceService {
	@Autowired
	SystemSourceRepository systemSourceRepository;
	
	public SystemSourceEntity saveSystemSource(SystemSourceEntity systemSourceEntity) {
		SystemSourceEntity savedData = systemSourceRepository.save(systemSourceEntity);
		return savedData;
	}
	public List<SystemSourceEntity> getAllSystemSource() {
		List<SystemSourceEntity> list = StreamSupport
		.stream(systemSourceRepository.findAll().spliterator(), false)
		.collect(Collectors.toList());
		return list;
	}
	public List<SystemSourceEntity> findBycPurpose(String purpose) {
		List<SystemSourceEntity> list = StreamSupport
				.stream(systemSourceRepository.findBycPurpose(purpose).spliterator(), false)
				.collect(Collectors.toList());
		return list;
	}
	public List<SystemSourceEntity> findBycPurposeAndiIdParent(String cPurpose,Long iIdParent) {
		List<SystemSourceEntity> list = StreamSupport
				.stream(systemSourceRepository.findBycPurposeAndiIdParent(cPurpose,iIdParent).spliterator(), false)
				.collect(Collectors.toList());
		return list;
	}
	
	
}
