package com.sda.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CreateUserDto {

    @NotNull
    private String name;
    @NotNull
    private String surname;

    @NotNull
    @Min(18)
    @Max(99)
    private int age;
}
