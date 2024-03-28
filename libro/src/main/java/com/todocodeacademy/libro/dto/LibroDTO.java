package com.todocodeacademy.libro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {
    private Integer isbn;
    private String title;
    private LocalDate yearOfPublication;
    private String description;
}
