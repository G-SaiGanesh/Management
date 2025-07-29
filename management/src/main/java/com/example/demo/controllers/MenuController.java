package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Menu;
import com.example.demo.service.MenuService;
@RestController
@RequestMapping("/menu")

public class MenuController {
	
	@Autowired
	private MenuService menuService;
	@GetMapping("/")
    public String home() {
        return "Welcome to Spring Boot!";
    }
	
	
	
	@PostMapping("/createmenu")
	public Menu savemenu(@RequestBody Menu menu) {
		return menuService.save(menu);
	}

	@GetMapping("/getAllMenu")
	private List<Menu> getAllMenu() {
		return menuService.getAll();
	}
	
    @GetMapping("/{id}")
    public Optional<Menu> getMenuById(@PathVariable Long id) {
        return menuService.getmenubyid(id);
    }

	
	
	@PutMapping("/updatemenu/{id}")
	private Menu updatemenu(@PathVariable Long id,@RequestBody Menu menu) {
		
		return menuService.update(id, menu);
		
	}
	@DeleteMapping("/{id}")
	private void deleteMenuId(@PathVariable Long id) {
		menuService.deletemenu(id);
	}
}
	
	
