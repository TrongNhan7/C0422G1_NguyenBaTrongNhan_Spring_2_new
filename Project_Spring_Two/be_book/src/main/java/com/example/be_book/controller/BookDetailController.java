package com.example.be_book.controller;

import com.example.be_book.model.Book;
import com.example.be_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class BookDetailController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("/user/book/{id}")
    public ResponseEntity<Book> bookDetail(@PathVariable Long id) {

        Book book = this.iBookService.findByIdBook(id);

        if (book.equals("")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
