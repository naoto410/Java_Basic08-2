package com.example.demo.TodoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Task;

@Repository
public interface TodoRepository extends JpaRepository<Task, Long> {
}