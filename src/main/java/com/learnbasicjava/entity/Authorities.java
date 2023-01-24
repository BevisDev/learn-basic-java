package com.learnbasicjava.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Authorities")
public class Authorities {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;


    @ManyToOne
    @JoinColumn(name = "username")
    Account accounts;

    @ManyToOne
    @JoinColumn(name = "roleid")
    Roles roles;

    public Authorities(Account accounts, Roles roles) {
        this.accounts = accounts;
        this.roles = roles;
    }
}
