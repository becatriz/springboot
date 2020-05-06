package com.curso.api.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.api.rest.model.Usuario;
import com.curso.api.rest.repository.UsuarioRepository;



@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/*@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<String> init(@RequestParam (value = "nome", 
	defaultValue = "Nome não informado") 
	String nome, @RequestParam("salario") Double salario) {
		return new ResponseEntity<String>("Olá usuario rest spring boot seu nome é : "+ nome + 
				" E salario é: " + salario,  HttpStatus.OK);
	}*/
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id ) {
		
		 Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new ResponseEntity<Usuario>(usuario.get(),  HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> initAll() {
		
		List<Usuario> list = (List<Usuario>)  usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(list,  HttpStatus.OK);
	}
	
	
	
	

}
