package com.kyiminhan.spring.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kyiminhan.spring.entity.Account;
import com.kyiminhan.spring.service.AccountService;
import com.kyiminhan.spring.service.dto.AccountDto;

import lombok.Setter;

@RestController
@Setter(onMethod = @__(@Autowired))
@CrossOrigin
public class AccountController {

	private AccountService accService;

	@GetMapping(value = { "/accountDto/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDto> findAccountDtoById(@PathVariable final Long id) {

		final AccountDto accountDto = AccountDto.builder().build();
		final Account account = this.accService.findById(id);
		BeanUtils.copyProperties(account, accountDto);
		return new ResponseEntity<>(accountDto, HttpStatus.OK);
	}

	@GetMapping(value = { "/accountDto/list" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountDto>> findAccountDtoAll() {

		final List<AccountDto> list = new ArrayList<>();
		final Collection<Account> collections = this.accService.findAll();
		collections.forEach(account -> {
			final AccountDto accountDto = AccountDto.builder().build();
			BeanUtils.copyProperties(account, accountDto);
			list.add(accountDto);
		});

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(value = { "/account/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> findAccountById(@PathVariable final Long id) {

		final Account account = this.accService.findById(id);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@GetMapping(value = { "/account/list" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> findAccountAll() {

		final Collection<Account> collections = this.accService.findAll();

		final List<Account> newList = new ArrayList<>(collections);

		return new ResponseEntity<>(newList, HttpStatus.OK);
	}
}