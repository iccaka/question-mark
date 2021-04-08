package com.dev.iccaka.questionmark.dtos;

import com.sun.istack.NotNull;

public class UserDto {

    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String firstName;

    public UserDto(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
