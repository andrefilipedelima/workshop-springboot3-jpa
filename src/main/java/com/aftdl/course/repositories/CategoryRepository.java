package com.aftdl.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aftdl.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
