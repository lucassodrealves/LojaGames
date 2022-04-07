package com.generation.gamesNovo.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.gamesNovo.model.Classe;
import com.generation.gamesNovo.repository.ClasseRepository;
import com.generation.gamesNovo.repository.PersonagemRepository;

@RestController
@RequestMapping("/classes")
@CrossOrigin(origins="*",allowedHeaders="*")
public class ClasseController extends Classe {
	
	@Autowired
	ClasseRepository repositoryClasse;
	
	@Autowired
	PersonagemRepository repositoryPersonagem;
    
	
	@GetMapping
	public ResponseEntity<List<Classe>> getAllClasse(Classe classe){
		if(classe.getPersonagens()==null) {
		   return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(repositoryClasse.findAll());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Classe> getById(@PathVariable @Valid Long id){
		return repositoryClasse.findById(id)
		.map(resposta -> ResponseEntity.ok(resposta))
        .orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Classe>>getByNomeClasse(@PathVariable String nome,Classe classe){
		    	return ResponseEntity.ok(repositoryClasse.findAllByNomeContainingIgnoreCase(nome));
		    	
		   
		    
			
			//return ResponseEntity.notFound().build();
		
	}
		
	 @PostMapping
	 public ResponseEntity<Classe> postClasse(@RequestBody @Valid Classe classe){
		    	 return ResponseEntity.status(HttpStatus.CREATED).body(repositoryClasse.save(classe));
		     }
		 
	
	 
		 
	   @PutMapping
	   public ResponseEntity<Classe> putClasse(@RequestBody @Valid Classe classe){
		   if(repositoryClasse.existsById(classe.getId())==true){
			   return ResponseEntity.ok(repositoryClasse.save(classe));
		   }
		   else {
			   return ResponseEntity.notFound().build();
		   }
	   }
		   
	   @DeleteMapping("/{id}")
	   public ResponseEntity<Classe> deleteClasse(@PathVariable Long id){
		   if(repositoryClasse.existsById(id)) {
			   repositoryClasse.deleteById(id);
			   return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			   
		   }
		   else {
			   
			   return ResponseEntity.notFound().build();
		   }
		   
		   
	   }
	 }
				
				
		
	
	


