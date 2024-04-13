package com.todocodeacademy.libro.repository;


import com.todocodeacademy.libro.model.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(name = "author-service", url = "${feign.author.service.url}")
@FeignClient(name = "author-service")
public interface IAuthorAPI {
    @GetMapping("/authors/get/{id}")
    Author getAuthorById(@PathVariable("id") Integer id);
}
