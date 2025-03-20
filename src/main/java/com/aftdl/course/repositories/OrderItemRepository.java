package com.aftdl.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aftdl.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
