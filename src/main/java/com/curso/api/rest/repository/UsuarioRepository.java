package com.curso.api.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.api.rest.model.*;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	

}
