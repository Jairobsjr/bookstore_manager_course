package com.jairobarbosa.bookstoremanager.controller;

import com.jairobarbosa.bookstoremanager.dto.MessageResponseDTO;
import com.jairobarbosa.bookstoremanager.entity.Book;
import com.jairobarbosa.bookstoremanager.repository.BookRepository;
import com.jairobarbosa.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public MessageResponseDTO create(@RequestBody Book book) {
        return bookService.create(book);
    }
}
