package com.libarary.library.controller;


import com.libarary.library.service.IBorrowingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Cache-Control, Content-Language, Content-Type, Expires, Last-Modified")
@AllArgsConstructor
@RestController
@RequestMapping("api")
public class BorrowingController {


    private IBorrowingService iBorrowingService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<?> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return iBorrowingService.borrowBook(bookId, patronId);
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<?> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return iBorrowingService.returnBook(bookId, patronId);
    }
}
