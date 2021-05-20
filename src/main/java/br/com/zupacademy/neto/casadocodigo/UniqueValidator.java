package br.com.zupacademy.neto.casadocodigo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {
	private String domainAttribute;
	private Class<?> klass;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(Unique params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery(
				"select 1 from "+ klass.getName()+" where "+domainAttribute+"=:value"
				);
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.size() <= 1, "Foi encontrado mais de um "+klass+" com o atributo "+domainAttribute+" = "+value);

		return list.isEmpty();
	}
//	@Override
//	public boolean isValid(Object value, ConstraintValidatorContext context) {
//		Query query = em.createQuery("SELECT 1 FROM  " + entidadeDominio.getName() + " WHERE "
//				+ atributo + "=:value");
//		query.setParameter("value", value);
//		List<?> resultQuery = query.getResultList();
//		boolean entidadeExistente = !resultQuery.isEmpty();
//		return entidadeExistente;
//	}
}
