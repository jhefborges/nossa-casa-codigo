package com.nossacasacodigo.model;

/**
 * NovoLivro
 */
public class NovoLivro {
    private String titulo;

    private String subtitulo;

    private String conteudo;

    private String sumario;
    
    private Long numeroPg;

    private Long isbn;

    private Long categoria;

    private Long autor;


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

    public Long getNumeroPg() {
        return this.numeroPg;
    }

    public void setNumeroPg(Long numeroPg) {
        this.numeroPg = numeroPg;
    }

    public Long getIsbn() {
        return this.isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Long getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public Long getAutor() {
        return this.autor;
    }

    public void setAutor(Long autor) {
        this.autor = autor;
    }
    
}