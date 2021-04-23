package com.dev.iccaka.questionmark.dtos;

import com.dev.iccaka.questionmark.validators.ValidEmail;
import com.dev.iccaka.questionmark.validators.ValidPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ValidPassword
public class UserRegisterDto {

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    private String username;
}
