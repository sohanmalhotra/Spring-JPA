package com.example.truyumm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.truyumm.model.Cart;
import com.example.truyumm.model.Menu;
import com.example.truyumm.repository.MenuRepository;
import com.example.truyumm.repository.ProductRepository;

@Controller
public class CartController {

	@Autowired
	MenuRepository usersRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping("/menu-item-list-customer")
	public String showProduct(ModelMap map)
	{
		List<Menu> menu=(List<Menu>) usersRepository.findAll();
		List<Cart> cart=new ArrayList<>();
		for(Menu m:menu)
		{
			if(m.getActive().equals("Yes"))
			{
				Cart c=new Cart();
				c.setId(m.getId());
				c.setName(m.getName());
				c.setPrice(m.getPrice());
				c.setCategory(m.getCategory());
				c.setFreedelivery(m.getFreedelivery());
				cart.add(c);
				
			}
		}
		map.put("menulist",cart);
		
		return "menu-item-list-customer";	
	}
	
	
	@RequestMapping("/menu-item-list-customer-notification")
	public String saveCart(ModelMap map,@RequestParam Integer id)
	{
	
		 List<Menu> menu=(List<Menu>) usersRepository.findAll();
		 Cart c=new Cart();
		 for(Menu m:menu)
		 {
			 if(m.getId()==id)
			 {
				c.setId(id);
				c.setName(m.getName());
				 c.setFreedelivery(m.getFreedelivery()); 
				c.setPrice(m.getPrice());			
				 c.setCategory(m.getCategory());
				 
			 }
		 }
			
			
		
		 productRepository.save(c);
		
		 List<Menu> menu1=(List<Menu>) usersRepository.findAll();
			List<Cart> cart=new ArrayList<>();
			for(Menu m:menu1)
			{
				if(m.getActive().equals("Yes"))
				{
					Cart c1=new Cart();
					c1.setId(m.getId());
					c1.setName(m.getName());
					c1.setPrice(m.getPrice());
					c1.setCategory(m.getCategory());
					c1.setFreedelivery(m.getFreedelivery());
					cart.add(c1);
					
				}
			}
			map.put("cartlist",cart);
			
		  
		 
		return "menu-item-list-customer-notification";	
	}
	
	
	
	
	@RequestMapping("/cart-notification")
	public String deletefromCart(ModelMap map,@RequestParam Integer id)
	{
	
			
		
		
		
		productRepository.deleteById(id);
		 List<Cart> cart=(List<Cart>) productRepository.findAll();
		if(cart.size()>0)	
		{ map.put("cartlist",cart);
		return "cart-notification";
		}
		else
		{
			return "cart-empty";
		}
		
	}
	
	@RequestMapping("/cart")
	public String cartItems(ModelMap map) {
		List<Cart> c=(List<Cart>) productRepository.findAll();
		if(c.size()>0) {
		map.put("cartlist",c);
		return "cart";
		}
		else
			return "cart-empty";
	}
		
	
}
