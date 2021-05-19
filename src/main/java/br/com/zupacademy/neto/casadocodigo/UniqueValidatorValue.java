package br.com.zupacademy.neto.casadocodigo;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.neto.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.neto.casadocodigo.categorias.CategoriaRepository;

public class UniqueValidatorValue implements ConstraintValidator<UniqueValidator, String> {
	private String value;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public void initialize(UniqueValidator contraintAnnotation) {
		this.value = contraintAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Optional<?> instance;
		System.out.println(value);
		if(value.contains("@")) {
			 instance = autorRepository.findByEmail(value);
			 System.out.println(value);
		} else {
			System.out.println(value);
			instance = categoriaRepository.findByNome(value);
		}
					
		if(instance.isEmpty()) {
			return true;
		}
		return false;
	}
	
}
