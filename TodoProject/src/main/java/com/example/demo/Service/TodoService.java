package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Task;
import com.example.demo.TodoRepository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	
	public List<Task> getAllTask() {
		return todoRepository.findAll();
	}
	
	public void saveTask(Task task) {
		task.setCreatedAt(LocalDateTime.now());
		todoRepository.save(task);
	}
	
	public void deleteTask(Long id) {
		todoRepository.deleteById(id);
	}
	
	public void toggleStatus(Long id) {
		Task task = todoRepository.findById(id).orElseThrow(() -> new RuntimeException());
		task.setCompleted(!task.isCompleted());
		todoRepository.save(task);
	}
	
	public Task getTaskId(Long id) {
		return todoRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}
}
