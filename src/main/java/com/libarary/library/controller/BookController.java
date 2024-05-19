package com.libarary.library.controller;


import com.libarary.library.model.Book;
import com.libarary.library.service.IBookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Cache-Control, Content-Language, Content-Type, Expires, Last-Modified")
@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private IBookService iBookService;

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(iBookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return iBookService.getBookById(id);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(iBookService.createBook(book), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return iBookService.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        return iBookService.deleteBook(id);
    }
}
