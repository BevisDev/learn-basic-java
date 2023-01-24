package com.learnbasicjava.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    /**
     * LAZY .. không lấy các đối tượng liên quan
     * *@ManyToMany và @OneToMany thì fetchType mặc định là LAZY
     */
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    List<Order> orders;

    /**
     * EAGER .. lay all doi tuong lien quan
     * *@ManyToOne và @OneToOne thì fetchType mặc định là EAGER
     */
    @OneToMany(mappedBy = "accounts", fetch = FetchType.EAGER)
    List<Authorities> authorities;

    public Account(String username, String password, String fullname, String email, String photo, Boolean activated, List<Order> orders) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.photo = photo;
        this.activated = activated;
        this.orders = orders;
    }

}
