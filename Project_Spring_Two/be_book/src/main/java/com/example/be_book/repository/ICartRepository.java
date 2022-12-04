package com.example.be_book.repository;

import com.example.be_book.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cart, Long> {

    @Query(value = "select * from cart ", nativeQuery = true)
    public List<Cart> findAllCart();
}
