package com.application.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.chat.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
