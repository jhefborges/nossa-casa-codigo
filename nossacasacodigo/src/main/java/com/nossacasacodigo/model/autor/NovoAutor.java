package com.nossacasacodigo.model.autor;

import javax.validation.constraints.NotBlank;

/**
 * NovoAutor
 */
public class NovoAutor {

    @Deprecated
    public NovoAutor() {
    }

    public NovoAutor(String nome) {
        this.nome = nome;
    }

    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    public String getNome() {
        return this.nome;
    }

}