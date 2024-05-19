package com.libarary.library.service;


import com.libarary.library.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookService {

    List<Book> getAllBooks();

    ResponseEntity<Book> getBookById(Long id);

    Book createBook(Book book);

    ResponseEntity<Book> updateBook(Long id, Book updatedBook);

    ResponseEntity<Void> deleteBook(Long id);

}
