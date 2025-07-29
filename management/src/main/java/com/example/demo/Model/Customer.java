package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customers")
public class Customer {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Long id;

	    private String name;
	    private String contact;
	    private String email;
	    private String address;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address ;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Customer(Long id, String name, String contact, String email, String address) {
			super();
			this.id = id;
			this.name = name;
			this.contact = contact;
			this.email = email;
			this.address = address;
		}
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Customer [id=" + id + ", name=" + name + ", contact=" + contact + ", email=" + email + ", address="
					+ address + "]";
		}
	    
	    
	}


