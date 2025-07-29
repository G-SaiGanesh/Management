package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Menu;
import com.example.demo.dao.MenuDao;

import jakarta.transaction.Transactional;
@Service
public class MenuService {
	
	@Autowired
	private MenuDao menudao;

	public Menu save(Menu menu) {
		// TODO Auto-generated method stub
		return menudao.save(menu);
	}

	public List<Menu> getAll() {
		// TODO Auto-generated method stub
		return menudao.findAll();
	}


	 @Transactional
	public Optional<Menu> getmenubyid(Long id) {
		// TODO Auto-generated method stub
		return menudao.findById(id);
	}

	public Menu update(Long id, Menu menu) {
		Menu existedMenu = menudao.findById(id).orElse(null);
	       
		if(existedMenu!=null) {
			existedMenu.setMenu_item(menu.getMenu_item());
			existedMenu.setMenu_price(menu.getMenu_price());
			existedMenu.setCategory(menu.getCategory());
			existedMenu.setMenu_availability(menu.getMenu_availability());
			
			return menudao.save(existedMenu);
		}else {
		return null;
		}	}
	
	public void deletemenu(Long id) {
		// TODO Auto-generated method stub
		menudao.deleteById(id);
	}
	
}
