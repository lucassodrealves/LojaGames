package com.generation.gamesNovo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="O nome é obrigatório.")
	@Size(min=2,max=999, message="o nome tem de ter no mínimo dois carácteres e no máximo 999.")
	private String nome;
	
	@NotBlank(message="O usuário é obrigatório e não pode ter espaços em branco")
	
	@Email(message="O usuário tem de ser no formato email")
	private String usuario;
	
	@NotBlank
	@Size(min=8, message="A senha tem de ter no mínimo oito carácteres.")
	private String senha;
	
	private String foto;
	
	@NotNull(message="A data de nascimento é obrigatória")
	private LocalDate localdate;
	
	@UpdateTimestamp
	private LocalDateTime h;
	
	public LocalDateTime getH() {
		return h;
	}

	public void setH(LocalDateTime h) {
		this.h = h;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		
			this.foto=foto;
			
		}
			


	public LocalDate getLocaldate() {
		
		return localdate;
	}

	public void setLocaldate(LocalDate localdate) {
		
		
		
			this.localdate = localdate;
			
		}
		
		//String Date   = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		

	@JsonIgnoreProperties("usuario")
	@OneToMany(mappedBy="usuario", cascade=CascadeType.REMOVE)
	private List<Personagem> personagens;

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Personagem> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<Personagem> personagens) {
		this.personagens = personagens;
	}

}
