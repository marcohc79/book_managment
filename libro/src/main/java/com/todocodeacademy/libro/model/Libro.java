package com.todocodeacademy.libro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Libro {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private Integer isbn;
        private String title;
        @Temporal(TemporalType.DATE)
        private LocalDate yearOfPublication;
        private String description;

        @ElementCollection(fetch = FetchType.EAGER)
        private List<String> authors;
}
