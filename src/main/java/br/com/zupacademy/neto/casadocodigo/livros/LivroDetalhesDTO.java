package br.com.zupacademy.neto.casadocodigo.livros;

import com.fasterxml.jackson.annotation.JsonCreator;
public class LivroDetalhesDTO {
    private final Integer id;
    private final String nome;

    @JsonCreator
    public LivroDetalhesDTO(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
