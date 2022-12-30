package com.consult.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consult.sales.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{

	//@Query("SELECT u FROM Usuario u WHERE u.user=:#{#usu.user} and u.password=#{#usu.password}")
	//public abstract Usuario login (@Param(value="usu") Usuario bean);
}
