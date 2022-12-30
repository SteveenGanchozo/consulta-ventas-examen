package com.consult.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consult.sales.entities.Producto;
import com.consult.sales.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pRepository;
	
	public List<Producto> listAll(){
		return pRepository.findAll();
	}
	
	public List<Producto> findOne(String idProducto){
		if (idProducto !="") {
			return pRepository.findAll(idProducto);
		} 
		return pRepository.findAll();
	}
	
	public void save(Producto product) {
		pRepository.save(product);
	}
	
	public Producto get(Long id) {
		return pRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		pRepository.deleteById(id);
	}
}
