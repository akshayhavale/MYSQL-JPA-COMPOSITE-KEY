package com.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Customer;
import com.app.entity.Organization_Owners;
import com.app.entity.Users;
import com.app.repository.CustomerRepository;
import com.app.repository.Organization_OwnersRepository;
import com.app.repository.UsersRepository;

@RestController
@RequestMapping(path = "/api/v1/orgowner")
public class OrganizationOwnersController {

	private final Organization_OwnersRepository organization_OwnersRepository;
	private final CustomerRepository customerRepository;
	private final UsersRepository usersRepository;

	public OrganizationOwnersController(final Organization_OwnersRepository organization_OwnersRepository,
			final CustomerRepository customerRepository, final UsersRepository usersRepository) {
		this.organization_OwnersRepository = organization_OwnersRepository;
		this.customerRepository = customerRepository;
		this.usersRepository = usersRepository;
	}

	@PostMapping(path = "/create")
	public void addOrgOwner() {
		Customer customer = customerRepository.findByCustomername("testcustomer");
		Users users = usersRepository.findByUsername("testuser");
		Organization_Owners organization_Owners = new Organization_Owners();
		organization_Owners.setCustomer(customer);
		organization_Owners.setUsers(users);
		organization_Owners.setPolicy(1L);
		organization_OwnersRepository.save(organization_Owners);
	}
	
	

}
