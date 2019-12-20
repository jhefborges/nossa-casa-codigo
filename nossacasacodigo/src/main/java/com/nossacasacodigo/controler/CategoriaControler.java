package com.nossacasacodigo.controler;

import javax.validation.Valid;

import com.nossacasacodigo.model.categoria.Categoria;
import com.nossacasacodigo.model.categoria.NovaCategoria;
import com.nossacasacodigo.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * CategoriaControler
 */
@Controller
public class CategoriaControler {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping("/novacategoria")
    public String novoAutor(@RequestBody @Valid NovaCategoria novaCategoria, BindingResult result, Model model){
        if(result.hasErrors()){
            return "novaCategoria";
        }
        Categoria categoria = new Categoria(novaCategoria.getCategoria());
        categoria = categoriaRepository.save(categoria);
        model.addAttribute(categoria);
        
        return "novaCategoria";
    }
        
}