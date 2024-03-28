package com.todocodeacademy.autor.service;

import com.todocodeacademy.autor.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todocodeacademy.autor.repository.IAutorRepository;

import java.util.List;

@Service
public class AutorService implements IAutorService{
    @Autowired
    private IAutorRepository autorRepository;

    @Override
    public List<Autor> getAutores() {
        return autorRepository.findAll();
    }

    @Override
    public void saveAutor(Autor autor) {
        autorRepository.save(autor);
    }

    @Override
    public void deleteAutor(Integer id) {
        autorRepository.deleteById(id);
    }

    @Override
    public Autor findAutor(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Autor> findAutorByISBN(Integer isbn) {
        return autorRepository.findByAutorByISBN(isbn);
    }
}
