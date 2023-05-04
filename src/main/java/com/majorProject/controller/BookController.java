package com.majorProject.controller;


import com.majorProject.entity.Book;
import com.majorProject.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book/upload")
    public Book postBook(@RequestParam("name") String name , @RequestParam("author") String author , @RequestParam("file")MultipartFile file) throws Exception {
        Book book = null;
        book = bookService.postBook(name,author,file);
        return book;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() throws Exception {
        return  bookService.getAll();
    }

    @GetMapping("/book/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam("query") String query){
        return ResponseEntity.ok(bookService.searchBooks(query));
    }
}
