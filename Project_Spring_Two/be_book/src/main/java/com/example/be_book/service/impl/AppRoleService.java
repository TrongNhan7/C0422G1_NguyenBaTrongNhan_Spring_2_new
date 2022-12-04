package com.example.be_book.service.impl;

import com.example.be_book.model.AppRole;
import com.example.be_book.repository.IAppRoleRepository;
import com.example.be_book.service.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private IAppRoleRepository iAppRoleRepository;

    @Override
    public List<AppRole> findByRoleName(String username) {
        return this.iAppRoleRepository.findByRoleName(username);
    }
}
