package com.aftdl.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aftdl.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
