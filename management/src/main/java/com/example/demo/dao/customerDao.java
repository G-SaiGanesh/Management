package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Customer;

public interface customerDao extends JpaRepository<Customer, Long>{

}
