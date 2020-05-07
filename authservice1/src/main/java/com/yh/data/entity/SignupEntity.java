package com.yh.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
// 前端传递的数据
public class SignupEntity {
	private String username;
	private String usertype;
	private String email;
	private String mobile;
	private PasswordsGroup passwordsGroup; 
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	@Getter
	@Setter
	public class PasswordsGroup{
		public String password;
		public String pwconfirm;
	}
	

}
