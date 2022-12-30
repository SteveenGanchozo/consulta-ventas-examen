package com.consult.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.consult.sales.entities.Producto;
import com.consult.sales.service.ProductService;


@Controller
public class ProductControlller {

	@Autowired
	private ProductService pService;

	@GetMapping("/products")
	public String listProduct(Model model) {
		
		List<Producto> listProducts = pService.listAll();
		
		model.addAttribute("listProducts", listProducts);
		
		return "index"; 
	}

	@GetMapping("/consult")
	public String consultSale(Model model, @Param("idProduct") String idProduct) {
	
		List<Producto> listProducts = pService.findOne(idProduct);
		
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("idProducto",idProduct);
		return "index"; 
	}
	
	@GetMapping("/new_product")
	public String formRegistProduct(Model model) {
		Producto product = new Producto();
		model.addAttribute("product", product);
		return "new_product";
	}

	@PostMapping("/save_product")
	public String saveProduct(@ModelAttribute("product") Producto product) {
		pService.save(product);
		return "redirect:/products";
	}

	@GetMapping("/update_product/{id}")
	public ModelAndView updateProduct(@PathVariable(name = "id") Long id) {
		ModelAndView model = new ModelAndView("update_product");
		Producto product = pService.get(id);
		model.addObject("product", product);
		return model;
	}

	@GetMapping("/delete_product/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		pService.delete(id);
		return "redirect:/products";
	}

}
