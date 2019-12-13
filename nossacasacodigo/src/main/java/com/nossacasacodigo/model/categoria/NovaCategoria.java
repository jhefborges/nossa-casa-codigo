package com.nossacasacodigo.model.categoria;

import javax.validation.constraints.NotBlank;

/**
 * NovaCategoria
 */
public class NovaCategoria {
    @NotBlank(message = "Categoria é obrigatoria")
    private String categoria;

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}