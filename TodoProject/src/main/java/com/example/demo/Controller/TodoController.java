package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entity.Task;
import com.example.demo.Service.TodoService;
@Controller
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/List")
	public String todoList(Model model) {
		model.addAttribute("tasks", todoService.getAllTask());
		return "List";
	}
	
	@GetMapping("/New")
	public String getNew() {
		return "New";
	}
	
	@GetMapping("/Add")
	public String addTask(Task task) {
		todoService.saveTask(task);
		return "redirect:/List";
	}
	
	@GetMapping("/Delete/{id}")
	public String deleteTask(@PathVariable Long id) {
		todoService.deleteTask(id);
		return "redirect:/List";
	}
	
	@GetMapping("/Toggle/{id}")
	public String toggleStatus(@PathVariable Long id) {
		todoService.toggleStatus(id);
		return "redirect:/List";
	}
	
	@GetMapping("/Edit/{id}")
	public String editform(@PathVariable Long id, Model model) {
		Task task = todoService.getTaskId(id);
		model.addAttribute("task", task);
		return "Edit";
	}
	
	@GetMapping("/Edit")
	public String editTask(Task task) {
		todoService.saveTask(task);
		return "redirect:/List";
	}
}