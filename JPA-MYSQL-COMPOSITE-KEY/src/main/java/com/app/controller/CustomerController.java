package com.app.controller;

import java.util.List;
import java.util.Map;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Customer;
import com.app.entity.Users;
import com.app.repository.CustomerRepository;
import com.app.repository.UsersRepository;

@RestController
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {

	private final CustomerRepository customerRepository;
	private final UsersRepository usersRepository;

	public CustomerController(final CustomerRepository customerRepository, final UsersRepository usersRepository) {
		this.customerRepository = customerRepository;
		this.usersRepository = usersRepository;
	}

	@PostMapping(path = "/create")
	public void createCustomer() {
		Users users = usersRepository.findByUsername("testuser");
		Customer customer = new Customer();
		customer.setCustomername("testcustomer");
		customer.setCreateUser(users);
		customer.setUpdateUser(users);
		customerRepository.save(customer);

	}
	
	@GetMapping(path = "/all")
	public List<Map<String, Object>> getCustomers(){
		return customerRepository.getAllCustomer();
	}

}
