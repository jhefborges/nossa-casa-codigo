package com.nossacasacodigo.controler;

import com.nossacasacodigo.model.Categoria;
import com.nossacasacodigo.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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
    public String novoAutor(@RequestBody String request,Model model){

        try {
            JSONObject json = new JSONObject(request);
            Categoria categoria = new Categoria();
            categoria.setCategoria(json.getString("categoria"));
            categoria = categoriaRepository.save(categoria);
            model.addAttribute(categoria);
            
        } catch (JSONException e) {
            System.out.println(e);
            e.printStackTrace();
            model.addAttribute("operacao","nova categoria");
            model.addAttribute("motivo",e.getMessage());
            return "erro";
        }
        
        return "novaCategoria";
    }
        
}