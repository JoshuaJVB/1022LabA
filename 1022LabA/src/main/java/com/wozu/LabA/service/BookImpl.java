package com.wozu.LabA.service;

import com.wozu.LabA.model.Book;
import com.wozu.LabA.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookImpl implements BookService{

    @Autowired
    BookRepo bookRepo;

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public void saveBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    public Optional<Book> updateBook(Book newBook, Long id) {
        bookRepo.findById(id)
                .map(book ->{
                    book.setAuthor(newBook.getAuthor());
                    book.setTitle(newBook.getAuthor());
                    return bookRepo.save(book);
                });
        return bookRepo.findById(id);
    }

    @Override
    public void removeBook(long id) {
        bookRepo.deleteById(id);
    }
}
