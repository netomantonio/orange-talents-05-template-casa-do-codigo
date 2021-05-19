package br.com.zupacademy.neto.casadocodigo.categorias;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.neto.casadocodigo.UniqueValidator;


public class CategoriaDTO {
	
	@NotBlank
	@UniqueValidator
	private String nome;
	
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public CategoriaDTO(String nome) {
		super();
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}
}
