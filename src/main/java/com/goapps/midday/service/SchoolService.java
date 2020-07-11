package com.goapps.midday.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goapps.midday.entity.SchoolEntity;
import com.goapps.midday.repository.SchoolRepository;

@Service
public class SchoolService {
	@Autowired
	 SchoolRepository schoolRepository;
	
	public SchoolEntity saveSchool(SchoolEntity schoolEntity) {
		SchoolEntity savedData = schoolRepository.save(schoolEntity);
		return savedData;
	}
	public List<SchoolEntity> getAllSchool() {
		List<SchoolEntity> list = StreamSupport
		.stream(schoolRepository.findAll().spliterator(), false)
		.collect(Collectors.toList());
		return list;
	}
	public SchoolEntity getSchoolById(Long id) {
		return schoolRepository.findById(id).get();
	}
	/*public List<SystemSourceEntity> findBycPurpose(String purpose) {
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
	}*/
	
	
}
