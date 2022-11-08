package com.example.shopproject.service.impl;
import com.example.shopproject.model.Users;
import com.example.shopproject.model.dto.UsersDto;
import com.example.shopproject.repository.UsersRepository;
import com.example.shopproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;


    @Override
    public UsersDto getById(long id) {
        Users users = usersRepository.findById(id);
        return UsersDto.builder()
                .name(users.getName())
                .surname(users.getSurname())
                .age(users.getAge())
                .username(users.getUsername())
                .build();
    }

    @Override
    public UsersDto getByNameAndSurname(String name, String surname) {
        Users users = usersRepository.findByNameAndSurname(name, surname);
        return UsersDto.builder()
                .name(users.getName())
                .surname(users.getSurname())
                .age(users.getAge())
                .username(users.getUsername())
                .build();

    }



    @Override
    public UsersDto getByUsernameAndPassword(String username, String password) {
        Users users = usersRepository.findByUsernameAndPassword(username, password);
        UsersDto usersDto = null;

        if (users != null) {
            usersDto = UsersDto.builder()
                    .name(users.getName())
                    .surname(users.getSurname())
                    .age(users.getAge())
                    .username(users.getUsername())
                    .build();
        }

        return usersDto;

    }

    @Override
    public boolean existUserControl(String usrname) {
        return usersRepository.existsUsersByUsername(usrname);
    }

    @Override
    public String registrationUser(Users user) {
        System.out.println(user.getUsername());
        if (existUserControl(user.getUsername())) {
            return "Bu istifadəçi adı artığ mövcuddur";
        } else {
            usersRepository.save(user);
            return "Qeydiyyatdan uğurla keçdiniz!";
        }
    }

    @Override
    public String loginUser(String username, String password) {
        UsersDto usersDto = getByUsernameAndPassword(username, password);

        if (usersDto != null) {
            return usersDto.toString();
        } else {
            return "istifadəçi adı vəya şifrə səhvdir";
        }
    }
}
