package com.hcl.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
public class User {
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(Long accountNum, String name, String email) {
		this.accountNum = accountNum;
		this.name = name;
		this.email = email;
	}
	
	private Long accountNum;
	private String name;
	private String email;

}
