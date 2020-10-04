package com.sda.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CarDto {
    private String model;
    private String company;
    private int year;
}
