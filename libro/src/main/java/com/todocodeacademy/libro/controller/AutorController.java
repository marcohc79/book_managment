package com.todocodeacademy.libro.controller;

import com.todocodeacademy.libro.dto.LibroDTO;
import com.todocodeacademy.libro.model.Libro;
import com.todocodeacademy.libro.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/libro")
public class AutorController {
    @Autowired
    private ILibroService libroService;

    @PostMapping("/save")
    public String saveLibro(@RequestBody LibroDTO libroDTO) {
        libroService.saveLibro(libroDTO.getIsbn(), libroDTO.getTitle(), libroDTO.getYearOfPublication(), libroDTO.getDescription());
        return "Saved";
    }
    @GetMapping("/get")
    public List<Libro> getLibro(){
        return libroService.getLibros();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLibro(@PathVariable Integer id){
        libroService.deleteLibro(id);
        return "Delete";
    }
}
