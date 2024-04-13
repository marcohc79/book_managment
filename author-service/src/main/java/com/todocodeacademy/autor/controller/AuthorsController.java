package com.todocodeacademy.autor.controller;

import com.todocodeacademy.autor.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.todocodeacademy.autor.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public String saveAutor(@RequestBody Author autor) {
        authorService.saveAuthor(autor);
        return "Saved authors";
    }

    @GetMapping("/get")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthorById(id);
        return "Deleted author";
    }

    @PutMapping("/edit/{id}")
    public String editAuthor(@PathVariable Integer id, @RequestBody Author author) {
        Boolean flag = authorService.editAuthor(id, author);
        return flag.toString();
    }

    @GetMapping("/get/{id}")
    public Author getAuthorById(@PathVariable Integer id) {
        return authorService.findAuthorById(id);
    }
}
