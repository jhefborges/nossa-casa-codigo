package com.nossacasacodigo.model.autor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Autor
 */
@Entity
public class Autor {

    @Deprecated
    public Autor() {
    }

    public Autor(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String nome;
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

}