package com.optum.accountdgs.dtos;

import lombok.Data;

//DTO
@Data
public class JwtRequest {

	private String userName;
	private String userPwd;
	
	
}
