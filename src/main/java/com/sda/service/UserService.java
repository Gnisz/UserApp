package com.sda.service;

import com.sda.domain.User;
import com.sda.domain.UserAndCar;
import com.sda.dto.CarDto;
import com.sda.dto.CreateUserDto;
import com.sda.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final RestTemplate restTemplate;

    private static String CARS_URL = "http://localhost:8069/cars";


    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.repository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User create(CreateUserDto dto) {

        User user = User.builder()
                .name((dto.getName()))
                .surname(dto.getSurname())
                .age(dto.getAge())
                .build();

        repository.save(user);
        return user;
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User findUserById( Long id){
        return repository.findUserById(id);

    }

    public UserAndCar connectUserWithCarsById (Long id){
        List<CarDto> response = restTemplate.getForObject
                (CARS_URL+"/external/"+id, List.class);

        User user = repository.findUserById(id);

        UserAndCar userAndCars =UserAndCar.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .cars(response)
                .build();

        return  userAndCars;
    }

}
