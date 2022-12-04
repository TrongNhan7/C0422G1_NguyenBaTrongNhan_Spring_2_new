package com.example.be_book.controller;

import com.example.be_book.jwt.JwtUtil;
import com.example.be_book.model.AppUser;
import com.example.be_book.model.LoginRequest;
import com.example.be_book.model.LoginResponse;
import com.example.be_book.service.IUserService;
import com.example.be_book.service.impl.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/public")
public class LoginRestController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody LoginRequest loginRequest) {

        AppUser account = iUserService.findByEmail(loginRequest.getEmail());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetailService = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<String> roles = userDetailService.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new ResponseEntity<>(new LoginResponse(jwtUtil.generateToken(account.getUsername()), account.getId(),account.getAvatar(),account.getUsername(), roles), HttpStatus.OK);
    }
}
