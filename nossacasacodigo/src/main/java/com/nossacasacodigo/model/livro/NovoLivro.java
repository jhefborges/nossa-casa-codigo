package com.nossacasacodigo.model.livro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

/**
 * NovoLivro
 */
public class NovoLivro {
    @NotBlank(message = "Título é obrigatorio")
    private String titulo;

    @NotBlank(message = "Subtítulo é obrigatorio")
    private String subtitulo;

    @NotBlank(message = "Conteúdo é obrigatorio")
    private String conteudo;

    @NotBlank(message = "Sumário é obrigatorio")
    private String sumario;

    @NotNull(message = "Número de Paginas é obrigatorio")
    private Long numeroPg;

    @NotNull(message = "ISBN é obrigatorio")
    private Long isbn;

    @NotNull(message = "Categoria é obrigatoria")
    private Long categoria;

    @NotNull(message = "Autor é obrigatorio")
    private Long autor;

    @NotBlank(message = "Imagem é obrigatoria")
    @URL(message = "Imagem deve ser um URL")
    private String imagemUrl;

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

    public String getImagemUrl() {
        return this.imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
    
}