package com.todocodeacademy.autor.controller;

import com.todocodeacademy.autor.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.todocodeacademy.autor.service.AutorService;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PostMapping("/save")
    public String saveAutor(@RequestBody Autor autor) {
        autorService.saveAutor(autor);
        return "Saved authors";
    }

    @GetMapping("/get")
    public List<Autor> getAutores() {
        return autorService.getAutores();
    }

    @GetMapping("/get/{isbn}")
    public List<Autor> getAutorByISBN(@PathVariable Integer isbn){
        return autorService.findAutorByISBN(isbn);
    }
}
