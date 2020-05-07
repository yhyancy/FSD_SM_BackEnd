package com.yh.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yh.data.entity.LoginEntity;
import com.yh.data.entity.SignupEntity;
import com.yh.data.entity.UserInfoDB;


@Mapper
@Repository
public interface UserInfoMapper {
	
	 UserInfoDB selectUserByName(LoginEntity user); // login 校验用户名密码
	 int addUser(UserInfoDB user); // signup 插入数据
    

}
