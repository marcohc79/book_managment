package com.todocodeacademy.libro.service;

import com.todocodeacademy.libro.dto.AuthorDTO;
import com.todocodeacademy.libro.dto.BookDTO;
import com.todocodeacademy.libro.model.Author;
import com.todocodeacademy.libro.model.Book;
import com.todocodeacademy.libro.repository.IAuthorAPI;
import com.todocodeacademy.libro.repository.IBookRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Autowired
    private IAuthorAPI authorAPI;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book, Integer authorId) {
        Author author = authorAPI.getAuthorById(authorId);
        if (author == null)
            return;
        Book newBook = new Book();
        List<Integer> listAuthorsId = new ArrayList<>();

        newBook.setIsbn(book.getIsbn());
        newBook.setTitle(book.getTitle());
        newBook.setYearOfPublication(book.getYearOfPublication());
        newBook.setDescription(book.getDescription());

        listAuthorsId.add(authorId);
        newBook.setAuthors_id(listAuthorsId);

        bookRepository.save(newBook);
    }

    @Override
    public Author getAuthor(Integer id) {
        return authorAPI.getAuthorById(id);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean editBookById(Integer bookId, Book newBook) {
        Book editBook = this.getBookById(bookId);
        if(editBook == null)
            return false;

        editBook.setIsbn(newBook.getIsbn() != null ? newBook.getIsbn() : editBook.getIsbn());
        editBook.setTitle(newBook.getTitle() != null ? newBook.getTitle() : editBook.getTitle());
        editBook.setDescription(newBook.getDescription() != null ? newBook.getDescription() : editBook.getDescription());
        editBook.setYearOfPublication(newBook.getYearOfPublication() != null ? newBook.getYearOfPublication() : editBook.getYearOfPublication());
        editBook.setAuthors_id(editBook.getAuthors_id());
        bookRepository.save(editBook);
        return true;
    }

    @Override
    public void deleteBookById(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    @CircuitBreaker(name = "author-service", fallbackMethod =  "fallbackMethodAuthorBook")
    @Retry(name = "author-service")
    public BookDTO getBookDTOById(Integer bookId) {
        Book book = this.getBookById(bookId);
        if(book == null)
            return null;
        BookDTO bookDTO = new BookDTO();
        List<Integer> listAuthorsId = book.getAuthors_id();
        List<AuthorDTO> authorsDTO = new ArrayList<>();

        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setYearOfPublication(book.getYearOfPublication());
        bookDTO.setDescription(book.getDescription());

        for(Integer authorId : listAuthorsId) {
            Author author = authorAPI.getAuthorById(authorId);
            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setFullName(author.getFullName());
            authorDTO.setNationality(author.getNationality());
            authorsDTO.add(authorDTO);
        }
        bookDTO.setAuthors(authorsDTO);
        return bookDTO;
    }

    public BookDTO fallbackMethodAuthorBook(Throwable throwable) {
        return new BookDTO(0, null, null, null, null);
    }

    @Override
    public void addAuthor(Integer authorId, Integer bookId) {
        Book book = this.getBookById(bookId);
        Author author = authorAPI.getAuthorById(authorId);
        if (book == null || author == null)
            return;
        List<Integer> listAuthorsId = book.getAuthors_id();
        listAuthorsId.add(author.getId());
        book.setAuthors_id(listAuthorsId);
        bookRepository.save(book);
    }
}
