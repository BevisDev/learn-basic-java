package com.learnbasicjava.dao;


import com.learnbasicjava.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, String> {

}
