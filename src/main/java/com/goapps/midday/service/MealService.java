package com.goapps.midday.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.goapps.midday.entity.MealEntity;
import com.goapps.midday.exception.GenericException;
import com.goapps.midday.repository.MealRepository;
import com.goapps.midday.utitlity.ImageProcessing;

@Service
public class MealService {
	@Autowired
	 MealRepository mealRepository;
	
	@Autowired
	ImageProcessing imageProcessing;
	
	@Value("${image.path}")
	String imagePath;
	@Value("${image.prefix}")
	String imagePrefix;
	
	public MealEntity saveMeal(MealEntity mealEntity) throws GenericException{
		
		// check for img data
		if(mealEntity.getImageBeforeCook() != null) {
			String extension = imageProcessing.getImageExtension(mealEntity.getImageBeforeCook());
			String path = imagePath+(imagePrefix != null ? imagePrefix:"")+new Date().getTime()+"."+extension;
			imageProcessing.createFileFromBase64(mealEntity.getImageBeforeCook(), path);
			mealEntity.setImageBeforeCook(path);
		}
		MealEntity savedData = mealRepository.save(mealEntity);
		return savedData;
	}
	
	public List<MealEntity> getAllMeal() {
		List<MealEntity> list = StreamSupport
		.stream(mealRepository.findAll().spliterator(), false)
		.collect(Collectors.toList());
		return list;
	}
	public MealEntity getMealById(Long id) {
		return mealRepository.findById(id).get();
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
