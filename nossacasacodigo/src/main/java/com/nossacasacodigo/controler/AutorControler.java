package com.nossacasacodigo.controler;

import javax.validation.Valid;

import com.nossacasacodigo.model.autor.Autor;
import com.nossacasacodigo.model.autor.NovoAutor;
import com.nossacasacodigo.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * AutorControler
 */
@Controller
public class AutorControler {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping("/novoautor")
    public String novoAutor(@RequestBody @Valid NovoAutor novoAutor, BindingResult result,Model model){
        if(result.hasErrors()){
            return "novoAutor";
        } 
        Autor autor = new Autor(novoAutor.getNome());
        autor = autorRepository.save(autor);
        model.addAttribute(autor);
        
        return "novoAutor";
    }
    
}