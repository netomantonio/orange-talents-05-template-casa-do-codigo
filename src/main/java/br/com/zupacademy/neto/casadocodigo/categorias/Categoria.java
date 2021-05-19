package br.com.zupacademy.neto.casadocodigo.categorias;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private @NotBlank String nome;
	
	@Deprecated
	public Categoria() {
		
	}
	
	public Categoria(@NotBlank String categoria) {
		this.nome = categoria;
	}

	@Override
	public String toString() {
		return "Categoria [nome=" + nome + "]";
	}
	
}
