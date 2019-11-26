package com.nossacasacodigo.model.autor;

import javax.validation.constraints.NotBlank;

/**
 * NovoAutor
 */
public class NovoAutor {
    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}