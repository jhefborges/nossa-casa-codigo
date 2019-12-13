package com.nossacasacodigo.model.livro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.nossacasacodigo.model.autor.Autor;
import com.nossacasacodigo.model.categoria.Categoria;

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

    @NotBlank(message = "Subtitulo é obrigatorio")
    private String subtitulo;

    @NotBlank(message = "Conteúdo é obrigatorio")
    private String conteudo;

    @NotBlank(message = "Sumário é obrigatorio")
    private String sumario;

    @NotNull(message = "Número de paginas é obrigatorio")
    private Long numeroPaginas;

    @NotNull(message = "Número de paginas é obrigatorio")
    private Long isbn;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Categoria categoria;

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

    public Autor getAutor() {
        return this.autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public String getImagemUrl() {
        return this.imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }


}