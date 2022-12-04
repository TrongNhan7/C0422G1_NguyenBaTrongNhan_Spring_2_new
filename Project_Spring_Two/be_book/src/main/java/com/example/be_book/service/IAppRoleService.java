package com.example.be_book.service;

import com.example.be_book.model.AppRole;

import java.util.List;

public interface IAppRoleService {
    List<AppRole> findByRoleName(String username);
}
