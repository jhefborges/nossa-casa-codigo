package com.nossacasacodigo.controler;

import java.util.ArrayList;
import java.util.List;

import com.nossacasacodigo.model.Autor;
import com.nossacasacodigo.model.Categoria;
import com.nossacasacodigo.model.Livro;
import com.nossacasacodigo.model.NovoLivro;
import com.nossacasacodigo.repository.AutorRepository;
import com.nossacasacodigo.repository.CategoriaRepository;
import com.nossacasacodigo.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * LivroControler
 */
@Controller
public class LivroControler {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;
    
    @GetMapping("/livro/{id}")
    public String mostraLivro(@PathVariable ("id") long id, Model model){
        //setar livro atual
        
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id do livro invalido" + id));
        
        model.addAttribute(livro);
        return "livro";
    }

    @GetMapping("/livro/autor/{id}")
    public String listaLivroAutor(@PathVariable ("id") long id, Model model){
        //setar livro atual
        
        Iterable<Livro> livros = livroRepository.findAll();
        
        Autor autor = autorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id da categoria invalido" + id));

        List<Livro> livrosFiltrados = new ArrayList<Livro>();
        for(Livro livro :livros){
            if(livro.getAutor().getId() == id){
                livrosFiltrados.add(livro);
            }
        }
        model.addAttribute("titulo", "Livros do Autor "+autor.getNome());
        model.addAttribute("livros",livrosFiltrados);
        return "listaLivros";
    }

    @GetMapping("/livro/categoria/{id}")
    public String listaLivroCategoria(@PathVariable ("id") long id, Model model){
        //setar livro atual
        
        Iterable<Livro> livros = livroRepository.findAll();
        
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id do autor invalido" + id));

        List<Livro> livrosFiltrados = new ArrayList<Livro>();
        for(Livro livro :livros){
            if(livro.getCategoria().getId() == id){
                livrosFiltrados.add(livro);
            }
        }
        model.addAttribute("titulo", "Livros da Categoria "+categoria.getCategoria());
        model.addAttribute("livros",livrosFiltrados);
        return "listaLivros";
    }

    @PostMapping("/novolivro")
    public String novoLivro(@RequestBody NovoLivro novoLivro,Model model){

        try {
            Livro livro = new Livro();
            livro.setTitulo(novoLivro.getTitulo());
            livro.setSubtitulo(novoLivro.getSubtitulo());
            livro.setConteudo(novoLivro.getConteudo());
            livro.setSumario(novoLivro.getSumario());
            livro.setNumeroPaginas(novoLivro.getNumeroPg());
            livro.setIsbn(novoLivro.getIsbn());
            Categoria categoria = categoriaRepository.findById(novoLivro.getCategoria()).orElse(null);
            livro.setCategoria(categoria);
            Autor autor = autorRepository.findById(novoLivro.getAutor()).orElse(null);
            livro.setAutor(autor);
            livro = livroRepository.save(livro);
            model.addAttribute(livro);
            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            model.addAttribute("Erro",e.getMessage());
            return "novoLivroErro";
        }
        
        return "novoLivro";
    }

}