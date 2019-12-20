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

    @Deprecated
    public Livro(){
    }

    public Livro(String titulo, String subtitulo, String conteudo, String sumario, Long numeroPaginas, Long isbn, Autor autor, Categoria categoria, String imagemUrl) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.conteudo = conteudo;
        this.sumario = sumario;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.autor = autor;
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
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
    @NotNull(message = "Autor é obrigatorio")
    private Autor autor;

    @ManyToOne
    @NotNull(message = "Categoria é obrigatorio")
    private Categoria categoria;

    private String imagemUrl;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getSubtitulo() {
        return this.subtitulo;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public String getSumario() {
        return this.sumario;
    }

    public Long getNumeroPaginas() {
        return this.numeroPaginas;
    }

    public Long getIsbn() {
        return this.isbn;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public String getImagemUrl() {
        return this.imagemUrl;
    }

}