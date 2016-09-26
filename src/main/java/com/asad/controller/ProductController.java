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

import com.asad.model.Product;
import com.asad.service.ProductService;

@Controller
@RequestMapping(value="products")
public class ProductController {
	
	@Autowired
	ProductService productServices;
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ModelAndView getPage(){		
			ModelAndView view = new ModelAndView("products");
			return view;		
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Product product){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(productServices.saveOrUpdateProduct(product)){
			map.put("status","200");
			map.put("message","Your record have been saved successfully");
		}
		
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(Product product){
		Map<String,Object> map = new HashMap<String,Object>();
	
			List<Product> list = productServices.getProducts();
			
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
	public @ResponseBody Map<String,Object> delete(Product product){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(productServices.deleteProduct(product)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
}
