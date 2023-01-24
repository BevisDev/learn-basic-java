package com.learnbasicjava.dao;

import com.learnbasicjava.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesDAO extends JpaRepository<Authorities, Integer> {

}
