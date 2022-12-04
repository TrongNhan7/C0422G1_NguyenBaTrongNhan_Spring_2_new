package com.example.be_book.service.impl;

import com.example.be_book.dto.IBookDto;
import com.example.be_book.model.Book;
import com.example.be_book.repository.IBookRepository;
import com.example.be_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<IBookDto> findAllBookAndSearch(String title, String author , Pageable pageable) {
        return this.iBookRepository.findAllBookAndSearch(
                "%" + title + "%",
                "%" + author + "%",
                pageable
        );
    }

    @Override
    @Transactional
    public Book findByIdBook(Long id) {
        return this.iBookRepository.findByIdBook(id);
    }
}

