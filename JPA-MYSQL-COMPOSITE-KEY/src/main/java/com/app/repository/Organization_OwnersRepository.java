package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Organization_Owner_Key;
import com.app.entity.Organization_Owners;

public interface Organization_OwnersRepository extends JpaRepository<Organization_Owners, Organization_Owner_Key> {

}
