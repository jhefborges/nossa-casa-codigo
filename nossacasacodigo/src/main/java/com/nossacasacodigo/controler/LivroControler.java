package com.nossacasacodigo.controler;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.nossacasacodigo.model.autor.Autor;
import com.nossacasacodigo.model.categoria.Categoria;
import com.nossacasacodigo.model.livro.Livro;
import com.nossacasacodigo.model.livro.NovoLivro;
import com.nossacasacodigo.repository.AutorRepository;
import com.nossacasacodigo.repository.CategoriaRepository;
import com.nossacasacodigo.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

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

        Autor autor =livro.getAutor();
        model.addAttribute(autor);

        Categoria categoria = livro.getCategoria();
        model.addAttribute(categoria);
        
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


    @GetMapping(value = "/cadastroLivro")
    public ModelAndView mostraForm(){
        return new ModelAndView("cadastroLivro","novoLivro",new NovoLivro());
    }

    @PostMapping(value = "/novolivro")
    public ModelAndView novoLivro(@ModelAttribute @Valid NovoLivro novoLivro, BindingResult result, Model model){

        if(result.hasErrors()){
            return new ModelAndView("cadastroLivro","novoLivro",novoLivro);
        }
        try {
            Categoria categoria = categoriaRepository.findById(novoLivro.getCategoriaId())
            .orElseThrow(() -> new IllegalArgumentException("Id da categoria invalido" + novoLivro.getCategoriaId()));
            Autor autor = autorRepository.findById(novoLivro.getAutorId())
            .orElseThrow(() -> new IllegalArgumentException("Id da categoria invalido" + novoLivro.getAutorId()));
            Livro livro = new Livro(
                novoLivro.getTitulo(),
                novoLivro.getSubtitulo(),
                novoLivro.getConteudo(),
                novoLivro.getSumario(),
                novoLivro.getNumeroPg(),
                novoLivro.getIsbn(),
                autor,
                categoria,
                novoLivro.getImagemUrl()
            );
            livro = livroRepository.save(livro);
            model.addAttribute(livro);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            model.addAttribute("Erro",e.getMessage());
            return new ModelAndView("cadastroLivro","novoLivro",novoLivro);
        }
        
        return new ModelAndView("novoLivro");
    }

}