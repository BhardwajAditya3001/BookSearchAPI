package com.majorProject.service;

import com.majorProject.entity.Book;
import com.majorProject.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book postBook(String name , String author , MultipartFile file) throws Exception {
        Book book
                = new Book(name, author, file.getBytes());
        return bookRepository.save(book);
    }

    public List<Book> getAll() throws Exception {
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String query){
        List<Book> searched_books = bookRepository.searchBooks(query);
        return searched_books;
    }

}
