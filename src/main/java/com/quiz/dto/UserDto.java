package com.quiz.dto;

import com.quiz.common.Role;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private long id;

    private String name;

    private String lastName;

    private Set<Role> roles;
}
