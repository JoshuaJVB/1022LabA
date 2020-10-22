package com.wozu.LabA.service;

import com.wozu.LabA.model.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookService {

    Optional<Book> getBookById(Long id);
    Iterable<Book> getAllBooks();
    void saveBook(Book book);
    Optional<Book> updateBook(Book newBook, Long id);
    void removeBook(long id);
}
