package com.generation.gamesNovo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_classes")
public class Classe {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@NotNull(message="Tal valor não pode ser nulo")
		@Size(min=1,max=99,message="Tal nome de classe deve ter de um a noventa e nove carácteres")
		private String nome;
		
		@NotNull(message="Tal valor não pode ser nulo")
		@Size(min=1,max=999,message="A descrição da classe tem de ter de um a novecentos e noventa e nove carácteres")
		private String descricao;
		
		@Size(min=1,max=99,message="O nível da classe tem de ter de um a noventa e nove carácteres")
		private String nivel;
		
		@Size(min=1,max=99,message="o nome da empresa da classe tem de ter de um a noventa e nove carácteres")
		private String empresa;
		
		@OneToMany(mappedBy="classe",cascade=CascadeType.REMOVE)
		@JsonIgnoreProperties("classe")
		private List<Personagem> personagem;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getNivel() {
			return nivel;
		}

		public void setNivel(String nivel) {
			this.nivel = nivel;
		}

		public String getEmpresa() {
			return empresa;
		}

		public void setEmpresa(String empresa) {
			this.empresa = empresa;
		}

		public List<Personagem> getPersonagens() {
			return personagem;
		}

		public void setPersonagens(List<Personagem> personagens) {
			this.personagem = personagens;
		}

		
		
	}



