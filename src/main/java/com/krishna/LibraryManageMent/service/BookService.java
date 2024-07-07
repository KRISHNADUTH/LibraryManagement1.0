package com.krishna.LibraryManageMent.service;

import com.krishna.LibraryManageMent.model.Book;
import com.krishna.LibraryManageMent.repo.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<Book> insertBook(Book book) {
        return new ResponseEntity<>(bookRepository.save(book), HttpStatus.OK);
    }

    public Book findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    public Book findBookById(long id) {
        return bookRepository.findById(id).get();
    }
}
