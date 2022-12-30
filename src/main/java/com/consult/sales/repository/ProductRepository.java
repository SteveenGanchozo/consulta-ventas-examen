package com.consult.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consult.sales.entities.Producto;


public interface ProductRepository extends JpaRepository<Producto, Long>{

	@Query("SELECT p FROM Producto p WHERE p.id =?1")
	public List<Producto> findAll(String idProduct);
}
