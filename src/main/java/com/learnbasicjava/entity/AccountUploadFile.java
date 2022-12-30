package com.learnbasicjava.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "accountandloadfile")
public class AccountUploadFile {
    @Id
    String username;
    String password;
    String fullname;
    String photo;
    Boolean activated = false;
    int age;
}
