package com.example.be_book.service;

import com.example.be_book.model.Book;

import java.util.HashMap;
import java.util.Map;

public interface ICartService {
    Map<Book, Integer> bookMap = new HashMap<>();
}
