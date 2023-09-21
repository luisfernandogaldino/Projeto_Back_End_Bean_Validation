package com.projetojpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

 @Entity
 @Table(name= "Dograria")
  public class Dograria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "o nome não pode ser vazio")
	@NotBlank
	@NotEmpty
	private String nome;

	@NotNull
	@NotEmpty
	@NotBlank
	@Size( min = 1, max = 14, message = "Digite apenas até 14 digitos")
	private String cnpj;


	public Long getId(){
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj= cnpj;
	}


}
