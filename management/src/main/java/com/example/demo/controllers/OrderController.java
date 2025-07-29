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

import com.example.demo.Model.Order;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/order" )
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/create")
	public Order CreateOrder(@RequestBody Order order) {
		
		return orderservice.saveorder(order);
		
	}
	@GetMapping("/Orders")
	public List<Order> getAllOrder(){
		return orderservice.getOrder();
	}
       
	@GetMapping("/{id}")
	public Optional<Order> getById(@PathVariable Long id) {
		
		return orderservice.get(id);
	}
	
	@PutMapping("/{id}" )
	 public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
	  return orderservice.updated(id,order);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		orderservice.deletorder(id);
	}
	
}
