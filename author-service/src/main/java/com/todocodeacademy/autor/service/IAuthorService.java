package com.todocodeacademy.autor.service;

import com.todocodeacademy.autor.model.Author;

import java.util.Iterator;
import java.util.List;

public interface IAuthorService {
    List<Author> getAllAuthors();
    void saveAuthor(Author author);
    void deleteAuthorById(Integer id);
    Author findAuthorById(Integer id);
    Boolean editAuthor(Integer idAuthorEdit, Author author);
    // List<Author> findAuthorByISBN(Integer isbn);
}
