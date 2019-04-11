package com.kyiminhan.mm.spring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kyiminhan.mm.spring.entity.User;
import com.kyiminhan.mm.spring.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/", "/home" })
	public String home(final Model model) {
		if (this.userService.isEmpty()) {
			this.userService.initDataInsert();
		}
		return "home";
	}

	@GetMapping(value = { "/users" }, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Collection<User> list() {
		final Collection<User> collection = this.userService.findAll();
		return collection;
	}

	@GetMapping(value = { "/user/{id}" }, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public User detail(@PathVariable("id") final String id) {
		final User user = this.userService.findById(id);
		return user;
	}
}