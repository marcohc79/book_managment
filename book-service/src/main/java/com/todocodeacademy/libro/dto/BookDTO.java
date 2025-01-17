package com.todocodeacademy.libro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Integer isbn;
    private String title;
    private LocalDate yearOfPublication;
    private String description;
    private List<AuthorDTO> authors;
}
