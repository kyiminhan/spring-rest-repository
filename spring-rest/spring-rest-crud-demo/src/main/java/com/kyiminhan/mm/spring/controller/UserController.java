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

/**
 * The Class UserController.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since 2019/04/11 </BR>
 *        spring-rest-crud-demo system </BR>
 *        com.kyiminhan.mm.spring.controller </BR>
 *        UserController.java </BR>
 */
@RestController
public class UserController {

	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Home.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping(value = { "/", "/home" })
	public String home(final Model model) {
		if (this.userService.isEmpty()) {
			this.userService.initDataInsert();
		}
		return "home";
	}

	/**
	 * List.
	 *
	 * @return Collection
	 */
	@GetMapping(value = { "/users" }, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Collection<User> list() {
		final Collection<User> collection = this.userService.findAll();
		return collection;
	}

	/**
	 * Detail.
	 *
	 * @param id the id
	 * @return User
	 */
	@GetMapping(value = { "/user/{id}" }, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public User detail(@PathVariable("id") final String id) {
		final User user = this.userService.findById(id);
		return user;
	}
}