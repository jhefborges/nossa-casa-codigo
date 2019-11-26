package com.nossacasacodigo.model.livro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * Livro
 */
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Titulo é obrigatorio")
    private String titulo;

    @NotBlank(message = "Titulo é obrigatorio")
    private String subtitulo;

    private String conteudo;

    private String sumario;

    private Long numeroPaginas;

    private Long isbn;

    private long autorId;

    private long categoriaId;

    private String imagemUrl;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getSubtitulo() {
        return this.subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getSumario() {
        return this.sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public Long getNumeroPaginas() {
        return this.numeroPaginas;
    }

    public void setNumeroPaginas(Long numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Long getIsbn() {
        return this.isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public long getAutorId() {
        return this.autorId;
    }

    public void setAutorId(long autorId) {
        this.autorId = autorId;
    }

    public long getCategoriaId() {
        return this.categoriaId;
    }

    public void setCategoriaId(long categoriaId) {
        this.categoriaId = categoriaId;
    }
    
    public String getImagemUrl() {
        return this.imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }


}