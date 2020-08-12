package com.goapps.midday.service.meal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.goapps.midday.config.AppConstants;
import com.goapps.midday.entity.AttendanceEntity;
import com.goapps.midday.entity.MealEntity;
import com.goapps.midday.entity.UserEntity;
import com.goapps.midday.exception.GenericException;
import com.goapps.midday.exception.InvalidRequestException;
import com.goapps.midday.mesasge.MessageConfiguration;
import com.goapps.midday.repository.AttendanceRepository;
import com.goapps.midday.repository.MealRepository;
import com.goapps.midday.repository.user.UserDaoImpl;
import com.goapps.midday.utitlity.ImageProcessing;
import com.goapps.midday.valueobject.meal.SaveMealVO;
import com.goapps.midday.valueobject.meal.SaveMealVO.CookInformation;

@Service
public class MealService {
	@Autowired
	 MealRepository mealRepository;
	
	@Autowired
	ImageProcessing imageProcessing;
	
	@Autowired
	MessageConfiguration messageConfig;
	
	@Autowired
	UserDaoImpl userDao;
	
	@Autowired
	AttendanceRepository attendanceRepo;
	
	@Value("${image.path}")
	String imagePath;
	@Value("${image.prefix}")
	String imagePrefix;
	
	Logger LOG = LoggerFactory.getLogger(MealService.class);
	public MealEntity saveMeal(MealEntity mealEntity) throws GenericException{
		/*
		// check for img data
		if (mealEntity.getImageBeforeCook() != null) {
			String extension = imageProcessing.getImageExtension(mealEntity.getImageBeforeCook());
			String path = imagePath + (imagePrefix != null ? imagePrefix : "") + new Date().getTime() + "." + extension;
			imageProcessing.createFileFromBase64(mealEntity.getImageBeforeCook(), path);
			mealEntity.setImageBeforeCook(path);
		}
		 */
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

	public MealEntity mapSaveMealVO(SaveMealVO saveMealVO,String operation) throws Exception{
		
		MealEntity meal = null;
		try {
			if(operation.equals("save")) {
				//save
				meal = new MealEntity();
				BeanUtils.copyProperties(meal, saveMealVO);
			}
			else {
				//update not used for now
				/*
				 * meal = mealRepository.findById(saveMealVO.getMealId()).get();
				 * BeanUtils.copyProperties(meal, saveMealVO);
				 */
			}
		} 
		catch (InvocationTargetException e) {
			LOG.error(e.getMessage());
			throw e;
		}
		catch (IllegalAccessException e) {
			LOG.error(e.getMessage());
			throw e;
		}
		catch (Exception e) {
			LOG.error(e.getMessage());
			throw e;
		}
		return meal;
	}
	
	
	public MealEntity processMealRequest(MealEntity meal, SaveMealVO saveMealVO)
			throws InvalidRequestException, Exception {
		List<AttendanceEntity> attendanceList = new ArrayList<AttendanceEntity>();
		if (meal.getIsCook()) {
			// save meal record
			meal = mealRepository.save(meal);
			// saving cook attendance and photo
			for (CookInformation cookInformation : saveMealVO.getCookInformation()) {

				AttendanceEntity attendance = new AttendanceEntity();
				attendance.setSchoolId(meal.getSchoolId());
				attendance.setMealId(meal.getId());
				attendance.setUserId(cookInformation.getCookId());
				// upload cook image

				if (cookInformation.getCookImage() != null) {
					try {

						String extension = imageProcessing.getImageExtension(cookInformation.getCookImage());
						String path = imagePath + (imagePrefix != null ? imagePrefix : "") + new Date().getTime() + "."
								+ extension;
						imageProcessing.createFileFromBase64(cookInformation.getCookImage(), path);
						attendance.setCookImage(path);
					} catch (Exception e) {
						throw e;
					}
				}

				attendanceList.add(attendance);

			}
			attendanceRepo.saveAll(attendanceList);
			
			
		} else {
			// if cook is false, then add attaindance of cooks
			if (meal.getNoCookCause() == null) {
				throw new InvalidRequestException(messageConfig.getUserMessage().getInvalidNoCookCause());
			}
			// save meal record
			meal = mealRepository.save(meal);
			// add attaindance for cooks
			// get list of cooks
			List<UserEntity> cookList = userDao.getUserByRoleAndSchoolId(meal.getSchoolId(), AppConstants.ROLE_COOK);
			// logic for deciding to take attaindance is TBD, now for timing adding it in
			// case of no cook

			if (cookList.size() == 0) {
				throw new InvalidRequestException(messageConfig.getUserMessage().getNoCookMatched());
			} else {
				// preparing attaindance object
				for(UserEntity cook:cookList) {
					AttendanceEntity attendance = new AttendanceEntity();
					attendance.setSchoolId(meal.getSchoolId());
					attendance.setMealId(meal.getId());
					attendance.setUserId(cook.getId());
					attendanceList.add(attendance);
				}
				attendanceRepo.saveAll(attendanceList);

			}
		}
		return meal;
	}

	public boolean validateMealData(SaveMealVO meal) throws InvalidRequestException{
		if(meal.getSchoolId() == 0) {
			throw new InvalidRequestException(messageConfig.getUserMessage().getInvalidSchoolId());
		}
		
		return true;
	}
	
}
