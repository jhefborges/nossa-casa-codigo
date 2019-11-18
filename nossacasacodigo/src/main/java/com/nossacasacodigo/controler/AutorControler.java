package com.nossacasacodigo.controler;

import com.nossacasacodigo.model.Autor;
import com.nossacasacodigo.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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
    public String novoAutor(@RequestBody String request,Model model){

        try {
            JSONObject json = new JSONObject(request);
            Autor autor = new Autor();
            autor.setNome(json.getString("nome"));
            autor = autorRepository.save(autor);
            model.addAttribute(autor);
            
        } catch (JSONException e) {
            System.out.println(e);
            e.printStackTrace();
            model.addAttribute("operacao","novo autor");
            model.addAttribute("motivo",e.getMessage());
            return "erro";
        }
        
        return "novoAutor";
    }
    
}