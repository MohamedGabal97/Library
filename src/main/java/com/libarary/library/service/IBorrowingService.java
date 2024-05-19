package com.libarary.library.service;


import org.springframework.http.ResponseEntity;

public interface IBorrowingService {

    ResponseEntity<Void> borrowBook(Long bookId, Long patronId);

    ResponseEntity<Void> returnBook(Long bookId, Long patronId);

}
