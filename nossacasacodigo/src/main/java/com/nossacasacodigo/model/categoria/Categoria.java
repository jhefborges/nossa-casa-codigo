package com.nossacasacodigo.model.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Categoria
 */
@Entity
public class Categoria {

    @Deprecated
    public Categoria() {
    }

    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String categoria;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCategoria() {
        return this.categoria;
    } 

}