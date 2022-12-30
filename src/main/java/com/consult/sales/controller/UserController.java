package com.consult.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.consult.sales.entities.Usuario;
import com.consult.sales.service.UserService;



@Controller
public class UserController {

	@Autowired
	private UserService userServicio;


	@GetMapping("/create_user")
	public String formRegistUser(Model model) {
		Usuario usu = new Usuario();
		model.addAttribute("usu", usu);
		return "create_user";
	}

	@PostMapping("/save_user")
	public String saveUser(@ModelAttribute("usu") Usuario usu) {
		userServicio.save(usu);
		return "redirect:/products";
	}

	
	@GetMapping("/")
	public String loginUser(Model model) {
		Usuario usu = new Usuario();
		model.addAttribute("usu", usu);
		return "login";
	}

}
