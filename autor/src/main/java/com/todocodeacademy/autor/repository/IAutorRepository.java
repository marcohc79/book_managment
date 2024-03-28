package com.todocodeacademy.autor.repository;

import com.todocodeacademy.autor.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Integer> {
    @Query("SELECT a FROM Autor a WHERE :isbn MEMBER OF a.isbn")
    List<Autor> findByAutorByISBN(Integer isbn);
}
