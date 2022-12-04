package com.example.be_book.repository;

import com.example.be_book.dto.IBookDto;
import com.example.be_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b.id , b.image_url as  imageUrl , b.title , b.price , b.author " +
            "from book as b " +
            "where b.title like :title " +
            "and b.author like :author ",
            countQuery = "select b.image_url as imageUrl, b.title , b.price , b.author " +
                    "from book as b " +
                    "where b.title like :title " +
                    "and b.author like :author ", nativeQuery = true)
    Page<IBookDto> findAllBookAndSearch(@Param("title") String title, @Param("author") String author, Pageable pageable);

    @Query(value = "select * " +
            "from book as b " +
            "join category as c " +
            "on b.category_id = c.id " +
            "where b.id = :id ",nativeQuery = true)
    Book findByIdBook(@Param("id") Long id);
}
