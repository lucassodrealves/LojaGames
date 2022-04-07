package com.generation.gamesNovo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_personagens")
public class Personagem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Esse valor é obrigatório.")
	@Size(min=1,max=99,message="Insira um nome de um a 99 carácteres.")
	private String nome;
	
	@NotNull(message="Esse valor é obrigatório.")
	@Size(min=1,max=99,message="Insira um tamanho de valor mínimo de um carácter e máximo de noventa e nove carácteres")
	private String tamanho;
	
	@Size(min=1,max=99,message="Insira uma cor de 1 até 99 carácteres.")
	private String cor;
	
	@NotBlank(message="Esse valor não pode ser branco")
	@Size(min=1,max=9,message="Insira um poder de ataque de 1 a 9 números inteiros")
	private int poderAtaque;
	
	@NotBlank(message="Esse valor não pode ser branco")
	@Size(min=1,max=9,message="Insira um poder de defesa de 1 a 9 números inteiros")
	private int poderDefesa;
	
	@ManyToOne
	@JsonIgnoreProperties("personagem")
	private Classe classe;

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

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getPoderAtaque() {
		return poderAtaque;
	}

	public void setPoderAtaque(int poderAtaque) {
		this.poderAtaque = poderAtaque;
	}

	public int getPoderDefesa() {
		return poderDefesa;
	}

	public void setPoderDefesa(int poderDefesa) {
		this.poderDefesa = poderDefesa;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
