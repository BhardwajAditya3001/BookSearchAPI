package com.majorProject.repository;

import com.majorProject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query(value = "SELECT * FROM book p WHERE "+
            " p.name LIKE CONCAT('%' ,:query,'%')" +
            "OR p.author LIKE CONCAT('%',:query,'%')",nativeQuery = true)
    List<Book> searchBooks(String query);
}

