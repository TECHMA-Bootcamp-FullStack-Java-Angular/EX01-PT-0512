package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

}
