package com.learnbasicjava.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    String username;
    String password;
    String fullname;
    String email;
    String photo;
    Boolean activated;

    @OneToMany(mappedBy = "account")
    List<Order> orders;
}
