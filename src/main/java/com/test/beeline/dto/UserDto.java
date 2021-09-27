package com.test.beeline.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto extends BaseDto{
    private String name;
    private Integer postalCode;
    private LocalDate dateOfBirth;

}
