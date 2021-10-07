package com.works.repositories;


import com.works.entities.User;
import com.works.entities.UserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmailEqualsAllIgnoreCase(String email);

    @Query(value = "select  ID, FIRST_NAME,LAST_NAME,EMAIL,PHONE,ENABLED from USER  ", nativeQuery = true)
    List<UserList> userList();



}
