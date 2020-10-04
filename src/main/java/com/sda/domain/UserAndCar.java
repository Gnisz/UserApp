package com.sda.domain;

import com.sda.dto.CarDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAndCar {

    private Long id;
    private String name;
    private  String surname;
    private int age;
    private List<CarDto> cars;
}
