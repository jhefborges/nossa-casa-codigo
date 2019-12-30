package com.nossacasacodigo.model.livro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

/**
 * NovoLivro
 */
public class NovoLivro {

    public NovoLivro(){

    }

    public NovoLivro(String titulo, String subtitulo, String conteudo, String sumario, Long numeroPg, Long isbn, Long categoriaId, Long autorId, String imagemUrl) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.conteudo = conteudo;
        this.sumario = sumario;
        this.numeroPg = numeroPg;
        this.isbn = isbn;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
        this.imagemUrl = imagemUrl;
    }


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
    private Long categoriaId;

    @NotNull(message = "Autor é obrigatorio")
    private Long autorId;

    @NotBlank(message = "Imagem é obrigatoria")
    @URL(message = "Imagem deve ser um URL")
    private String imagemUrl;

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

    public Long getNumeroPg() {
        return this.numeroPg;
    }

    public Long getIsbn() {
        return this.isbn;
    }

    public Long getCategoriaId() {
        return this.categoriaId;
    }

    public Long getAutorId() {
        return this.autorId;
    }

    public String getImagemUrl() {
        return this.imagemUrl;
    }
	public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    public void setSumario(String sumario) {
        this.sumario = sumario;
    }
    public void setNumeroPg(Long numeroPg) {
        this.numeroPg = numeroPg;
    }
    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
    
}