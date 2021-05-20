package br.com.zupacademy.neto.casadocodigo.livros;

import br.com.zupacademy.neto.casadocodigo.autor.Autor;
import br.com.zupacademy.neto.casadocodigo.categorias.Categoria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivrosController{

	@PersistenceContext
	EntityManager em;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid LivroDTO livroDto){

		Autor autor = em.find(Autor.class, livroDto.getAutor());
		Categoria categoria = em.find(Categoria.class, livroDto.getCategoria());

		Livro novoLivro = livroDto.toModel(autor, categoria);

		em.persist(novoLivro);
	}

}