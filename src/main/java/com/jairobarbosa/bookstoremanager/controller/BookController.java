package com.jairobarbosa.bookstoremanager.controller;

import com.jairobarbosa.bookstoremanager.dto.BookDTO;
import com.jairobarbosa.bookstoremanager.dto.MessageResponseDTO;
import com.jairobarbosa.bookstoremanager.entity.Book;
import com.jairobarbosa.bookstoremanager.exception.BookNotFoundException;
import com.jairobarbosa.bookstoremanager.repository.BookRepository;
import com.jairobarbosa.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {

        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {

        return bookService.findById(id);
    }
}
