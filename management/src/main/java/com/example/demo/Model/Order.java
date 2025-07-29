package com.example.demo.Model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
        
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	  private Long id;
	  
	
	  @ManyToOne(fetch = FetchType.EAGER)
	  private Customer customer;
	  
	  @ManyToMany(fetch = FetchType.EAGER)
	  @JoinTable(
			  name ="Order_Item",
			  joinColumns = @JoinColumn(name="order_id"),
			  inverseJoinColumns = @JoinColumn(name="menu_item_id")
			  
			  )
	  private List <Menu> menuitems;
	  
	  private Double totalPrice;
	  
	  private LocalDateTime ordertime;
	  
	  private String Status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Menu> getMenuitems() {
		return menuitems;
	}

	public void setMenuitems(List<Menu> menuitems) {
		this.menuitems = menuitems;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(LocalDateTime ordertime) {
		this.ordertime = ordertime;
	}

	public String getStatus() {
		return  Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Order(Long id, Customer customer, List<Menu> menuitems, Double totalPrice, LocalDateTime ordertime,
			String status) {
		super();
		this.id = id;
		this.customer = customer;
		this.menuitems = menuitems;
		this.totalPrice = totalPrice;
		this.ordertime = ordertime;
		Status = status;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", menuitems=" + menuitems + ", totalPrice=" + totalPrice
				+ ", ordertime=" + ordertime + ", Status=" + Status + "]";
	}
	  
}
