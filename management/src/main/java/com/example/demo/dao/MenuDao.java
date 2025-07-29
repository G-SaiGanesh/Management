package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Menu;

public interface MenuDao extends JpaRepository<Menu, Long>{

}
