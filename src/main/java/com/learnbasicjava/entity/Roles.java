package com.learnbasicjava.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Roles")
public class Roles {
    @Id
    String id;
    String name;

    @OneToMany(mappedBy = "roles")
    List<Authorities> authorities;
}
