package com.todocodeacademy.libro.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {
    private Integer idAuthor;
    private String fullNameAuthor;
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirthAuthor;
    private String nationalityAuthor;
}
