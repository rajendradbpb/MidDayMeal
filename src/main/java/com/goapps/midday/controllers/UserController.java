package com.goapps.midday.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goapps.midday.config.AppConstants;
import com.goapps.midday.entity.AuthRequest;
import com.goapps.midday.entity.RoleEntity;
import com.goapps.midday.entity.UserEntity;
import com.goapps.midday.exception.InvalidRequestException;
import com.goapps.midday.mesasge.MessageConfiguration;
import com.goapps.midday.service.SchoolService;
import com.goapps.midday.service.user.UserService;
import com.goapps.midday.utitlity.Encoder;
import com.goapps.midday.utitlity.JwtUtil;
import com.goapps.midday.valueobject.user.AssignClassTeacherVO;
import com.goapps.midday.valueobject.user.SaveUserVO;
import com.goapps.midday.valueobject.user.SignupUserVO;
import com.goapps.midday.valueobject.user.UpdateUserVO;
import com.goapps.midday.valueobject.user.UserCount;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	
	@Autowired
	JwtUtil jwt;
	
	@Autowired
	MessageConfiguration messageConfig;
	@Autowired
	SchoolService schoolService; 
	
	@Autowired JwtUtil jwtUtil;
	
	@Autowired AuthenticationManager  authenticationManager;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		System.out.println(authRequest);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
					authRequest.getPassword() ));
		} 
		 catch (AuthenticationException e) {
				throw e;
			}
		catch (Exception e) {
			throw new Exception("Invalid Username or password");
		}
		return jwtUtil.generateToken(authRequest.getUsername());
	}
	@GetMapping("/jwt/{token}")
	public String getTokenDetails(@PathVariable String token) throws Exception {
		jwt.decodeJWT(token);
		return "success";
	}
	@PostMapping("/user")
	ResponseEntity<?> saveUser(@Validated @RequestBody SaveUserVO saveUserVO) throws Exception{
		UserEntity savedData = null;
		try {
			
			UserEntity userEntity = new UserEntity(saveUserVO.getUsername(), saveUserVO.getPassword(),
					saveUserVO.getSchoolId(), saveUserVO.getRollId(), saveUserVO.getFirstName());
			userService.validateUserData(userEntity,"save");
			userEntity.setPassword(userEntity.getPassword());
			savedData = userService.saveUser(userEntity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		return new ResponseEntity<>(savedData, HttpStatus.OK);
	}
	@PutMapping("/user")
	ResponseEntity<?> updateUser(@Validated @RequestBody UpdateUserVO updateUserVO) throws Exception{
		UserEntity userEntity = null;
		try {
			userEntity = userService.getUserById(updateUserVO.getUserId());
			userService.mapUpdatedUserVO(updateUserVO,userEntity); // passed user entity as input parameter
			userService.validateUserData(userEntity,"save");
			userEntity = userService.saveUser(userEntity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		return new ResponseEntity<>(userEntity, HttpStatus.OK);
	}
	@PostMapping("/admin/user")
	ResponseEntity<?> saveUserByAdmin(@Validated @RequestBody SaveUserVO saveUserVO) throws Exception{
		UserEntity savedData = null;
		try {
			
//			LOGGER.info(saveUserVO.toString());
			UserEntity userEntity = new UserEntity(saveUserVO.getUsername(), saveUserVO.getPassword(),
					saveUserVO.getSchoolId(), saveUserVO.getRollId(), saveUserVO.getFirstName());
			userService.validateUserData(userEntity,"save");
			userEntity.setPassword(userEntity.getPassword());
			savedData = userService.saveUser(userEntity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw e;
		}
		return new ResponseEntity<>(savedData, HttpStatus.OK);
	}
	@PostMapping("/user/signup")
	ResponseEntity<?> signUpUser(@Validated @RequestBody SignupUserVO signupUser) {
		UserEntity userData = null;
		try {
			if(!signupUser.getPassword().equals(signupUser.getConfirmPassword())) {
				throw new InvalidRequestException(messageConfig.getUserMessage().getPasswordConfirmPasswordNotMatched());
			}
			// load user from username
			userData = userService.getUserByUsername(signupUser.getUsername());
			userData.setPassword(signupUser.getPassword());
			userData.setStatus(AppConstants.STATUS_ACTIVE);
			userService.validateUserData(userData,AppConstants.USER_OPERATION_SIGNUP);
			userData.setPassword(passwordEncoder.encode(userData.getPassword()));
			userData = userService.saveUser(userData);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(userData, HttpStatus.OK);
	}
	@GetMapping("/user")
	ResponseEntity<?> getAllUser(@RequestParam(required = false) Long id) {
		try {
			if(id == null)
				return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
//			else if(id != null)
//				return new ResponseEntity<>(schoolService.getSchoolById(id), HttpStatus.OK);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/user/role")
	ResponseEntity<?> saveRole(@Validated @RequestBody RoleEntity roleEntity) {
		RoleEntity savedData = null;
		try {
			
			savedData = userService.saveRole(roleEntity);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(savedData, HttpStatus.OK);
	}
	
	@GetMapping("/user/role")
	ResponseEntity<?> getAllRole() {
		try {
			return new ResponseEntity<>(userService.getAllRole(), HttpStatus.OK);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	@GetMapping("/user/count/{schoolId}")
	public ResponseEntity<?> getUserCounts(@PathVariable(required = true) Long schoolId){
		List<UserCount> userCountList =  userService.getUserCounts(schoolId);
		return new ResponseEntity<>(userCountList, HttpStatus.OK);
	}
	@PutMapping("/user/assignClassTeacher")
	public ResponseEntity assignClassTeacher(@RequestBody @Validated AssignClassTeacherVO assignClassTeacher) throws Exception{
		userService.assignClassTeacher(assignClassTeacher);
		return new ResponseEntity(HttpStatus.OK);
	}
}
