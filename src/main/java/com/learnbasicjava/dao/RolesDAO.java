package com.learnbasicjava.dao;

import com.learnbasicjava.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesDAO extends JpaRepository<Roles, String> {

}
