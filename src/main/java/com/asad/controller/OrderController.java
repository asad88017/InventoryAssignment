package com.asad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asad.model.Order;
import com.asad.service.OrderService;

@Controller
@RequestMapping("orders")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ModelAndView getPage(){		
			ModelAndView view = new ModelAndView("orders");
			return view;		
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Order order){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(orderService.saveOrUpdateOrder(order)){
			map.put("status","200");
			map.put("message","Your record have been saved successfully");
		}
		
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(Order order){
		Map<String,Object> map = new HashMap<String,Object>();
	
			List<Order> list = orderService.getOrders();
			
			if (list != null){
				map.put("status","200");
				map.put("message","Data found");
				map.put("data", list);
			}else{
				map.put("status","404");
				map.put("message","Data not found");				
			}
		
		return map;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(Order order){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(orderService.deleteOrder(order)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}

}
