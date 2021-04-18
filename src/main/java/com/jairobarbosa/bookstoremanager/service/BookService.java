package com.jairobarbosa.bookstoremanager.service;

import com.jairobarbosa.bookstoremanager.dto.BookDTO;
import com.jairobarbosa.bookstoremanager.dto.MessageResponseDTO;
import com.jairobarbosa.bookstoremanager.entity.Book;
import com.jairobarbosa.bookstoremanager.exception.BookNotFoundException;
import com.jairobarbosa.bookstoremanager.mapper.BookMapper;
import com.jairobarbosa.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookRepository bookRepository;


    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toDTO(book);
    }
}
