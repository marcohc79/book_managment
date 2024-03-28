package com.todocodeacademy.autor.model;

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
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;
    private String nationality;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Integer> isbn;
}
