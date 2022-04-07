package com.generation.gamesNovo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.gamesNovo.model.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{
	public List<Classe> findAllByNomeContainingIgnoreCase(String nome);
	
	

}


