package com.kyiminhan.spring.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyiminhan.spring.entity.PersistentLogins;
import com.kyiminhan.spring.service.PersistentLoginService;

import lombok.Setter;

@RestController
@Setter(onMethod = @__(@Autowired))
public class PersistentLoginsController {

	private PersistentLoginService loginService;

	@GetMapping(value = { "/login/list" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersistentLogins>> findAccountAll() {

		final Collection<PersistentLogins> collections = this.loginService.findAll();

		final List<PersistentLogins> newList = new ArrayList<>(collections);

		return new ResponseEntity<>(newList, HttpStatus.OK);
	}
}