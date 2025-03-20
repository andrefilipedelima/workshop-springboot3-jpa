package com.aftdl.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aftdl.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
