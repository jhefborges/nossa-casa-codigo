package com.nossacasacodigo.model.categoria;

import javax.validation.constraints.NotBlank;

/**
 * NovaCategoria
 */
public class NovaCategoria {
    private String categoria;

    @NotBlank(message = "Categoria é obrigatoria")
    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}