package com.kyiminhan.spring.service.dto;

import java.time.LocalDateTime;

import com.kyiminhan.spring.types.AccountLock;
import com.kyiminhan.spring.types.DelFg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

	private Long id;
	private String uuid;
	private DelFg delFg;
	private String createdBy;
	private LocalDateTime createdDt;
	private String lastModifiedBy;
	private LocalDateTime lastModifiedDt;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private AccountLock accountLock;
	private int loginAttempt;
	private LocalDateTime loginDt;
}
