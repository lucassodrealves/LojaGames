package com.generation.gamesNovo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.gamesNovo.model.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
	
	
	public List<Personagem>findAllByNomeContainingIgnoreCase(String nome);
}
