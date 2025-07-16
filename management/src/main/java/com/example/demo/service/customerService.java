package com.example.demo.service; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.customerDao;
import com.example.demo.Model.Customer;

@Service
public class customerService {
	
	@Autowired
	private customerDao customerrepo;

	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return  customerrepo.save(customer);
	}

	public Customer updateCustomer(Long id, Customer updatedCustomer) {
		
	    Customer existingCustomer = customerrepo.findById(id).orElse(null);
	    if (existingCustomer != null) {
	        existingCustomer.setName(updatedCustomer.getName());
	        existingCustomer.setContact(updatedCustomer.getContact());
	        existingCustomer.setEmail(updatedCustomer.getEmail());
	        existingCustomer.setAddress(updatedCustomer.getAddress());
	        return customerrepo.save(existingCustomer);
	    } else {
	        return null;
	    }

	}
	public void deleteCustomer(Long id) {
        customerrepo.deleteById(id);
    }

	public Customer getCustomer(Long id) {
		// TODO Auto-generated method stub
		return  customerrepo.getById(id);
	}

	

	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerrepo.findAll();
	}

	

	
	

}
