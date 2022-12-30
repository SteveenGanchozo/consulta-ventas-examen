package com.consult.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consult.sales.entities.Usuario;
import com.consult.sales.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepositorio;
	
	public void save(Usuario usu) {
		userRepositorio.save(usu);
	}
}
