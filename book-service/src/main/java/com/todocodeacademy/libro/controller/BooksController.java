package com.todocodeacademy.libro.controller;

import com.todocodeacademy.libro.dto.BookDTO;
import com.todocodeacademy.libro.model.Author;
import com.todocodeacademy.libro.model.Book;
import com.todocodeacademy.libro.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/get")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/save/{author_id}")
    public String saveBook(@RequestBody Book book, @PathVariable Integer author_id) {
        bookService.saveBook(book, author_id);
        return "Saved";
    }

    @GetMapping("/get/authors/{author_id}")
    public Author getAuthorById(@PathVariable Integer author_id) {
        return bookService.getAuthor(author_id);
    }

    @GetMapping("/get/{book_id}")
    public Book getBookById(@PathVariable Integer book_id) {
        return bookService.getBookById(book_id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return "Deleted";
    }

    @PutMapping("/edit/{book_id}")
    public String editBook(@RequestBody Book book, @PathVariable Integer book_id) {
        Boolean flag = bookService.editBookById(book_id, book);
        if (flag)
            return "Edited";
        return "Not edited";
    }

    @GetMapping("/information/{book_id}")
    public BookDTO getBookInformation(@PathVariable Integer book_id) {
        return bookService.getBookDTOById(book_id);
    }

    @PutMapping("/{book_id}/add/{author_id}")
    public String addAuthor(@PathVariable Integer book_id , @PathVariable Integer author_id) {
        bookService.addAuthor(author_id, book_id);
        return "Added";
    }
}
