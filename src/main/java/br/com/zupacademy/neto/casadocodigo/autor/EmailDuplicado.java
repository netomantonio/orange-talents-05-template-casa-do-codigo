package br.com.zupacademy.neto.casadocodigo.autor;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = EmailDuplicadoValidator.class)
public @interface EmailDuplicado {
	
	String message() default "Email já cadastrado";
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	String value() default "";
}
