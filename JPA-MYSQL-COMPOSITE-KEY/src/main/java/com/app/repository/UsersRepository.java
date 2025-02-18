package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String string);

}
