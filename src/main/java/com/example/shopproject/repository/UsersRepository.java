package com.example.shopproject.repository;
import com.example.shopproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
   Users findById(long id);
   Users findByNameAndSurname(String name, String surname);
   Users findByUsernameAndPassword(String username,String password);
   boolean existsUsersByUsername(String username);

}
