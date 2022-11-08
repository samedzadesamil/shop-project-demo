package com.example.shopproject.service;



import com.example.shopproject.model.Users;
import com.example.shopproject.model.dto.UsersDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UsersDto getById(long id);

    public UsersDto getByNameAndSurname(String name, String surname);

    public UsersDto getByUsernameAndPassword(String username, String password);

    public boolean existUserControl(String usrname);

    public String registrationUser(Users user);

    public String loginUser(String username, String password);


}
