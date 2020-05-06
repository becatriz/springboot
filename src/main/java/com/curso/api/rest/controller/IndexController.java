package com.curso.api.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


	@GetMapping(value = "/{id}/codigovenda/{idvenda}", produces = "application/json")
	public ResponseEntity<Usuario> relatorio(@PathVariable(value = "id") Long id, @PathVariable (value = "idvenda") Long idvenda) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		return new ResponseEntity<Usuario>(usuario.get(),  HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> initAll() {
		
		List<Usuario> list = (List<Usuario>)  usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(list,  HttpStatus.OK);
	}

	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario>cadastrar(@RequestBody Usuario usuario){


		Usuario usuarioSalvo = usuarioRepository.save(usuario);

		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);

	}

	@PostMapping(value = "/{iduser}/idvenda/{idvenda}", produces = "application/json")
	public ResponseEntity<Usuario>cadastrarvenda(@PathVariable Long iduser, @PathVariable Long idvenda){

		//Usuario usuarioSalvo = usuarioRepository.save(usuario);


		return new ResponseEntity(" id user:" + iduser + " id venda:  " +idvenda, HttpStatus.OK);

	}

	@DeleteMapping(value = "/{iduser}", produces = "application/json")
	public ResponseEntity<Usuario>deleteusuario(@PathVariable Long iduser){

		 usuarioRepository.deleteById(iduser);

		return new ResponseEntity("Usuario deletado id: " + iduser, HttpStatus.OK);

	}


}
