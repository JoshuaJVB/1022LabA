package com.wozu.LabA.controller;

import com.wozu.LabA.model.Book;
import com.wozu.LabA.service.BookImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookImpl bookService;

    //get method
    @GetMapping("/get/{id}")
    public Optional<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    //save
    @PostMapping("/post")
    public void saveBook(@RequestBody Book book){
        bookService.saveBook(book);
    }

    //update
    @PutMapping("/put/{id}")
    public Optional<Book> updateBook(@RequestBody Book newBook, @PathVariable Long id){
        return bookService.updateBook(newBook, id);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.removeBook(id);
        return "Book deleted";
    }
}
