package com.yh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yh.data.entity.LoginEntity;
import com.yh.data.entity.LoginReturn;
import com.yh.data.entity.UserInfoDB;
import com.yh.data.mapper.UserInfoMapper;
import com.yh.tools.TokenTool;


@RestController
@CrossOrigin("*") // allow cross domain
public class LoginController {
	private final UserInfoMapper userInfoMapper;
	
	@Autowired
	public LoginController(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}
	
	@RequestMapping("/login") 
	public LoginReturn authUnamePwd(@RequestBody(required = true) LoginEntity authUser, HttpServletRequest res, HttpServletResponse req) {
		// 1. if authUser is null -> return 0 -> user not found
		if(authUser==null) {
			return new LoginReturn("","",0,"");
		}
		// 2. if authUser is not null, query the authUser info in db according the autherUser
		UserInfoDB authInfoDB= userInfoMapper.selectUserByName(authUser);
		 // if authInfoDB is null ->   return 0 -> user not found
		if(authInfoDB == null) {
			return new LoginReturn("","",0,"");
		}
		// 3. compare whether the authUser pw in db equals authUser pw.
		// 3.1 not equal -> return  -1 -> user password incorrect
		if(!authInfoDB.getPassword().equals(authUser.getPassWord())) {
			return new LoginReturn("","",-1,"");
		}
		// 3.2 equal -> return user is active and generate the jwt token 
		else {
			//generate token
			String token= TokenTool.getToken(authInfoDB);
			return new LoginReturn(token,authInfoDB.getUser_name(),1,authInfoDB.getUser_type());
		}
	}

}
