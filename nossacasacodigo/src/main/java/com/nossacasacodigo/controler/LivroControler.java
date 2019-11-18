package com.nossacasacodigo.controler;

import com.nossacasacodigo.model.Livro;
import com.nossacasacodigo.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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
    
    @GetMapping("/livro/{id}")
    public String mostraLivro(@PathVariable ("id") long id, Model model){
        //setar livro atual
        
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id do livro invalido" + id));
        
        model.addAttribute(livro);
        return "livro";
    }

    @PostMapping("/novolivro")
    public String novoLivro(@RequestBody String request,Model model){

        try {
            JSONObject json = new JSONObject(request);
            Livro livro = new Livro();
            livro.setTitulo(json.getString("titulo"));
            livro.setSubtitulo(json.getString("subtitulo"));
            livro.setConteudo(json.getString("conteudo"));
            livro.setSumario(json.getString("sumario"));
            livro.setNumeroPaginas(json.getLong("numeroPg"));
            livro.setIsbn(json.getLong("isbn"));
            livro = livroRepository.save(livro);
            model.addAttribute(livro);
            
        } catch (JSONException e) {
            System.out.println(e);
            e.printStackTrace();
            model.addAttribute("Erro",e.getMessage());
            return "novoLivroErro";
        }
        
        return "novoLivro";
    }

}