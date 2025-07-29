package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Menu;
import com.example.demo.Model.Order;
import com.example.demo.dao.MenuDao;
import com.example.demo.dao.OrderDao;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderdao;
	@Autowired
	private MenuDao menudao;

	public Order saveorder(Order order) {
		
		
		Double total = 0.0;
		 List<Menu> actualMenus = new ArrayList<>();
		
		for (Menu item : order.getMenuitems())  {
			
			Menu menu =menudao.findById(item.getId()).orElse(null);
			
			if(menu!=null) {
				
				total+=menu.getMenu_price();
				actualMenus.add(menu); 
			}

		    order.setMenuitems(actualMenus); 
			order.setTotalPrice(total);
			   if (order.getOrdertime() == null) {
		            order.setOrdertime(java.time.LocalDateTime.now());
		        }
		}
		
		
		return orderdao.save(order);
	}

	public List<Order> getOrder() {
		// TODO Auto-generated method stub
		return orderdao.findAll();
	}

	public Optional<Order> get(Long id) {
		// TODO Auto-generated method stub
		return orderdao.findById(id);
	}

	public Order updated(Long id, Order order) {
		
		List<Menu> updatedMenus = new ArrayList<>();
		Order existedOrder=orderdao.findById(id).orElse(null);
		
		if(existedOrder!=null) {
			
			existedOrder.setCustomer(order.getCustomer());
			existedOrder.setMenuitems(order.getMenuitems());
			existedOrder.setStatus(order.getStatus());
			
			Double total =0.0;
			for(Menu items:order.getMenuitems()) {
				Menu menu=menudao.findById(items.getId()).orElse(null);
				if(menu!=null) {
				   total+=menu.getMenu_price();
				   updatedMenus.add(menu);
				}
				
					
				
			}
			existedOrder.setMenuitems(updatedMenus);
			existedOrder.setTotalPrice(total);
			
		}
		existedOrder.setOrdertime(LocalDateTime.now());
		return orderdao.save(existedOrder);
	}

	public void deletorder(Long id) {
	
		orderdao.deleteById(id);
	}
        
}
