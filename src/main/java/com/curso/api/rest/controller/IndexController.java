package com.curso.api.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<String> init(@RequestParam (value = "nome", 
	defaultValue = "Nome não informado") 
	String nome, @RequestParam("salario") Double salario) {
		return new ResponseEntity<String>("Olá usuario rest spring boot seu nome é : "+ nome + 
				" E salario é: " + salario,  HttpStatus.OK);
	}
	
	

}
