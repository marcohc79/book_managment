package com.todocodeacademy.autor.repository;

import com.todocodeacademy.autor.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Integer> {
//    @Query("SELECT a FROM Author a WHERE :isbn MEMBER OF a.isbn")
//    List<Author> findByAutorByISBN(Integer isbn);
}
