package com.todocodeacademy.libro.service;

import com.todocodeacademy.libro.dto.AutorDTO;
import com.todocodeacademy.libro.model.Libro;
import com.todocodeacademy.libro.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LibroService implements ILibroService {
    @Autowired
    ILibroRepository libroRepository;

    @Autowired
    private RestTemplate apiConsumir;

    @Override
    public List<Libro> getLibros() {
        return libroRepository.findAll();
    }

    @Override
    public void saveLibro(Integer isbn, String title, LocalDate yearOfPublication, String description) {
        Libro libro = new Libro();
        List<String> autores = new ArrayList<>();
        List<AutorDTO> autoresDTO = Arrays.asList(apiConsumir.getForObject("http://localhost:9001/autor/get/"+String.valueOf(isbn), AutorDTO[].class));

        libro.setIsbn(isbn);
        libro.setTitle(title);
        libro.setYearOfPublication(yearOfPublication);
        libro.setDescription(description);

        for (AutorDTO autors : autoresDTO){
            autores.add(autors.getFullNameAuthor());
        }
        libro.setAuthors(autores);
        libroRepository.save(libro);
    }

    @Override
    public void deleteLibro(Integer id) {
        libroRepository.deleteById(id);
    }
}
