package br.com.zupacademy.neto.casadocodigo.autor;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	AutorRepository autorRepository;
	
	
	@PostMapping
	@Transactional
	public void cadastrar(@Validated AutorDTO autorDTO ) {
		Autor autorNovo = autorDTO.toModel();		
		autorRepository.save(autorNovo);
	}
}
