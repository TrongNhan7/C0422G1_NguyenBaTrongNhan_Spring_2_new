package com.example.be_book.service;

import com.example.be_book.model.AppUser;

public interface IUserService {
    AppUser findByUsername(String email);

    AppUser findByEmail(String email);

}
