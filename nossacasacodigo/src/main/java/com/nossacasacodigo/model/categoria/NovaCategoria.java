package com.nossacasacodigo.model.categoria;

import javax.validation.constraints.NotBlank;

/**
 * NovaCategoria
 */
public class NovaCategoria {
    
    
    @Deprecated
    public NovaCategoria() {
    }

    public NovaCategoria(String categoria) {
        this.categoria = categoria;
    }

    @NotBlank(message = "Categoria é obrigatoria")
    private String categoria;

    public String getCategoria() {
        return this.categoria;
    }
    
}