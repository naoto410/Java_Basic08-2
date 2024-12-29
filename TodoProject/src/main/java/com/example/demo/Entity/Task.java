package com.example.demo.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed;
    private String createdAt;
    
	public void setCreatedAt(LocalDateTime createdAt) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd HH:mm");
		this.createdAt = createdAt.format(formatter);
	}
    
    public boolean isCompleted() {
    	return completed;
    }
}