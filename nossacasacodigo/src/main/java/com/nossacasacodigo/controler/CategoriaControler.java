package com.nossacasacodigo.controler;

import com.nossacasacodigo.model.Categoria;
import com.nossacasacodigo.model.NovaCategoria;
import com.nossacasacodigo.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String novoAutor(@RequestBody NovaCategoria novaCategoria,Model model){

        try {
            Categoria categoria = new Categoria();
            categoria.setCategoria(novaCategoria.getCategoria());
            categoria = categoriaRepository.save(categoria);
            model.addAttribute(categoria);
            
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            model.addAttribute("operacao","nova categoria");
            model.addAttribute("motivo",e.getMessage());
            return "erro";
        }
        
        return "novaCategoria";
    }
        
}