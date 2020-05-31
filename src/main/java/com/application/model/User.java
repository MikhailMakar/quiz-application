package com.application.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity {

    @Column
    private String name;

    @Column
    private String lastName;

    @Column(name = "role")
    private Set<Role> roles;
}
