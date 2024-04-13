package com.todocodeacademy.autor.service;

import com.todocodeacademy.autor.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todocodeacademy.autor.repository.IAuthorRepository;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author findAuthorById(Integer id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean editAuthor(Integer idAuthorEdit, Author author) {
        Author authorToEdit = this.findAuthorById(idAuthorEdit);
        if (authorToEdit == null)
            return false;
        authorToEdit.setFullName(author.getFullName() != null ? author.getFullName() : authorToEdit.getFullName());
        authorToEdit.setBirthDate(author.getBirthDate() != null ? author.getBirthDate() : authorToEdit.getBirthDate());
        authorToEdit.setNationality(author.getNationality() != null ? author.getNationality() : authorToEdit.getNationality());
        authorRepository.save(authorToEdit);
        return true;
    }
}
