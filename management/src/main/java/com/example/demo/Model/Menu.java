package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="MenuDao")
public class Menu {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	private Long id;
	
	private String menu_item;
	
	private Double menu_price;
	
	private Boolean menu_availability;
	
	private String category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenu_item() {
		return menu_item;
	}

	public void setMenu_item(String menu_item) {
		this.menu_item = menu_item;
	}

	public Double getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(Double menu_price) {
		this.menu_price = menu_price;
	}

	public Boolean getMenu_availability() {
		return menu_availability;
	}

	public void setMenu_availability(Boolean menu_availability) {
		this.menu_availability = menu_availability;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Menu(Long id, String menu_item, Double menu_price, Boolean menu_availability, String category) {
		super();
		this.id = id;
		this.menu_item = menu_item;
		this.menu_price = menu_price;
		this.menu_availability = menu_availability;
		this.category = category;
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menu_item=" + menu_item + ", menu_price=" + menu_price + ", menu_availability="
				+ menu_availability + ", category=" + category + "]";
	}
	

}
