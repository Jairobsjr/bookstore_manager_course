package com.jairobarbosa.bookstoremanager.service;

import com.jairobarbosa.bookstoremanager.dto.MessageResponseDTO;
import com.jairobarbosa.bookstoremanager.entity.Book;
import com.jairobarbosa.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public MessageResponseDTO create(Book book) {
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }

}
