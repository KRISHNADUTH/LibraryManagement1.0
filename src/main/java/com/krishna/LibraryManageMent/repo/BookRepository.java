package com.krishna.LibraryManageMent.repo;

import com.krishna.LibraryManageMent.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByTitle(String title);
}
