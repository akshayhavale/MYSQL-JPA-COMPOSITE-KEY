package com.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Users;
import com.app.repository.UsersRepository;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UsersController {

	private final UsersRepository usersRepository;

	public UsersController(final UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@PostMapping("/create")
	public void createUser() {
		Users users = new Users();
		users.setUsername("testuser");
		usersRepository.save(users);
	}

}
