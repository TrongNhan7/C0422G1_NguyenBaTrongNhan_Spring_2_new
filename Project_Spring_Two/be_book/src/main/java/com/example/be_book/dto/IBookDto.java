package com.example.be_book.dto;

import com.example.be_book.model.Category;

public interface IBookDto {
    Long getId();

    String getTitle();

    String getPublisher();

    Integer getTotalPages();

    Double getWidth();

    String getAuthor();

    Double getHeight();

    Double getPrice();

    String getImageUrl();

    String getSummary();

    Integer getQuantity();

    Category getCategories();
}
