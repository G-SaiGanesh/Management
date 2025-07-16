package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Customer;
import com.example.demo.service.customerService;

@RestController
@RequestMapping("/customers")
public class customerController {
	
	
	@Autowired
	private customerService customerService;
	
	@GetMapping("/")
    public String home() {
        return "Welcome to Spring Boot!";
    }
	
	
	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer) {
		
		return customerService.save(customer);
		
		
	}
	
	@PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }
    
    @DeleteMapping("/{id}")
    public  void deletecustomer(@PathVariable Long id) {
    	
    	 customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}")
    public Customer getby(@PathVariable Long id) {
    	return customerService.getCustomer(id);
    }
    
    @GetMapping
    public List<Customer> getAllCustomers(){
    	return customerService.getAll()
;    }

}