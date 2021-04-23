package com.dev.iccaka.questionmark.validators;

import com.dev.iccaka.questionmark.dtos.UserRegisterDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, Object> {


    @Override
    public void initialize(ValidPassword constraintAnnotation) { }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        UserRegisterDto userRegisterDto = (UserRegisterDto) o;

        return userRegisterDto.getPassword().equals(userRegisterDto.getMatchingPassword());
    }
}
