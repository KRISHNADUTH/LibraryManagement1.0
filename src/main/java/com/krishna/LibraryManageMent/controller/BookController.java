package com.krishna.LibraryManageMent.controller;

import com.krishna.LibraryManageMent.exception.bookException.BookTitleNotFoundException;
import com.krishna.LibraryManageMent.model.Book;
import com.krishna.LibraryManageMent.service.BookService;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<Book> insertBook(@Valid @RequestBody Book book)
    {
        return bookService.insertBook(book);
    }

    @GetMapping("books/{id}")
    public Book findBookById(@PathVariable @Min(1) long id) {
        return bookService.findBookById(id);

    }

    @GetMapping("/books/title/{title}")
    public Book findBookByTitle(@PathVariable String title) throws BookTitleNotFoundException {
        Book bookByTitle = bookService.findBookByTitle(title);
        if (bookByTitle == null) {
            throw new BookTitleNotFoundException("Book title '" + title + "' cannot be found in DB");
        } 
        else
            return bookByTitle;
    }
}
