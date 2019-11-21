package com.nossacasacodigo.controler;

import com.nossacasacodigo.model.Autor;
import com.nossacasacodigo.model.NovoAutor;
import com.nossacasacodigo.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String novoAutor(@RequestBody NovoAutor novoAutor,Model model){

        try {
            Autor autor = new Autor();
            autor.setNome(novoAutor.getNome());
            autor = autorRepository.save(autor);
            model.addAttribute(autor);
            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            model.addAttribute("operacao","novo autor");
            model.addAttribute("motivo",e.getMessage());
            return "erro";
        }
        
        return "novoAutor";
    }
    
}