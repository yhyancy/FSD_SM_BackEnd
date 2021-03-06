package com.yh.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.yh.data.entity.SignupEntity;
import com.yh.data.entity.SignupReturn;
import com.yh.data.entity.UserInfoDB;
import com.yh.data.mapper.UserInfoMapper;


@RestController
@CrossOrigin("*")
public class SignupController {
	@Autowired
	UserInfoMapper userInfoMapper;	
	
	@PostMapping("/signup")// 增加user数据
	public SignupReturn signup(@RequestBody(required = true) SignupEntity signupEntity) {	
	
			UserInfoDB userInfoDB = formatUserInfo(signupEntity);
			userInfoMapper.addUser(userInfoDB);		
			
			
			return new SignupReturn("ok");		
		
	}
	private UserInfoDB formatUserInfo(SignupEntity signupEntity) {
		Date date= new Date();
		return new UserInfoDB(0,signupEntity.getUsername(), signupEntity.getPasswordsGroup().getPassword(), signupEntity.getUsertype(),signupEntity.getEmail(),signupEntity.getMobile(),"N",date,"" );
	}
	
	

}
