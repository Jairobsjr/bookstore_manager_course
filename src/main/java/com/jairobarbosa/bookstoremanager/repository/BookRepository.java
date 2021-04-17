package com.jairobarbosa.bookstoremanager.repository;

import com.jairobarbosa.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
