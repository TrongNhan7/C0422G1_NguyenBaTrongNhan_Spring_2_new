package com.example.be_book.service;

import com.example.be_book.dto.IBookDto;
import com.example.be_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<IBookDto> findAllBookAndSearch(String title, String author, Pageable pageable);

    Book findByIdBook(Long id);
}
