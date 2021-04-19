package com.dev.iccaka.questionmark.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String username;

    private String firstName;

    private String middleName;

    private String lastName;

    private String title;

    private String description;

    private String website;

    private String university;
}
