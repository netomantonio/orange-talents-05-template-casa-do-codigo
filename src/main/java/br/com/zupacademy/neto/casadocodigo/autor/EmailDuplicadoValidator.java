package br.com.zupacademy.neto.casadocodigo.autor;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailDuplicadoValidator implements ConstraintValidator<EmailDuplicado, String> {
	private String value;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public void initialize(EmailDuplicado contraintAnnotation) {
		this.value = contraintAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Optional<Autor> autor = autorRepository.findByEmail(value);
		
		if(autor.isEmpty()) {
			return true;
		}
		return false;
	}
	
}
