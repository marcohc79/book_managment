package com.todocodeacademy.libro.service;

import com.todocodeacademy.libro.dto.BookDTO;
import com.todocodeacademy.libro.model.Author;
import com.todocodeacademy.libro.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    void saveBook(Book book, Integer authorId);
    Author getAuthor(Integer id);
    Book getBookById(Integer id);
    Boolean editBookById(Integer bookId, Book newBook);
    void deleteBookById(Integer bookId);
    BookDTO getBookDTOById(Integer bookId);
    void addAuthor(Integer authorId, Integer bookId);
}
