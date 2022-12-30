package com.learnbasicjava.dao;

import com.learnbasicjava.entity.AccountUploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountUploadFileDAO extends JpaRepository<AccountUploadFile, String> {
}