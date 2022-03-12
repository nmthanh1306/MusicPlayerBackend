package com.is1423.musicplayerbackend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.is1423.musicplayerbackend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String userName);

    Optional<User> findUserByUserNameAndPassword(String userName, String password);


}
