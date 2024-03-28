package com.todocodeacademy.libro.service;

import com.todocodeacademy.libro.model.Libro;

import java.time.LocalDate;
import java.util.List;

public interface ILibroService {
    List<Libro> getLibros();
    void saveLibro(Integer isbn, String title, LocalDate yearOfPublication, String description);
    void deleteLibro(Integer id);
}
