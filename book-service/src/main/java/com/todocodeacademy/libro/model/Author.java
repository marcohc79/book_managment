package com.todocodeacademy.libro.model;

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
public class Author {
    private Integer id;
    private String fullName = null;
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate = null;
    private String nationality = null;
}
