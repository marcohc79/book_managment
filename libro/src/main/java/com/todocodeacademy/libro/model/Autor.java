package com.todocodeacademy.libro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    private Integer idAuthor;
    private String fullName;
    private LocalDate yearOfBirth;
    private List<Integer> isbn;
}
