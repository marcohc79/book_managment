package com.todocodeacademy.autor.service;

import com.todocodeacademy.autor.model.Autor;

import java.util.List;

public interface IAutorService {
    List<Autor> getAutores();
    void saveAutor(Autor autor);
    void deleteAutor(Integer id);
    Autor findAutor(Integer id);
    List<Autor> findAutorByISBN(Integer isbn);
}
