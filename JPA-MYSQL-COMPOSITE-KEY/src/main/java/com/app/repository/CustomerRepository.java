package com.app.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByCustomername(String string);
	
	/**
	 * Best article to understand join vs join fetch 
	 * {@link}https://stackoverflow.com/questions/17431312/what-is-the-difference-between-join-and-join-fetch-when-using-jpa-and-hibernate
	 * @return
	 */

	@Query(value = "select new Map(c.customername as customername, oo.policy as policy) from Customer c join c.organization_Owners as oo where oo.users.id = 1")
	List<Map<String, Object>> getAllCustomer();

}
