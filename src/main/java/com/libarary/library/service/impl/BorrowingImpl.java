package com.libarary.library.service.impl;

import com.libarary.library.model.Book;
import com.libarary.library.model.BorrowingRecord;
import com.libarary.library.model.Patron;
import com.libarary.library.repository.BookRepository;
import com.libarary.library.repository.BorrowingRecordRepository;
import com.libarary.library.repository.PatronRepository;
import com.libarary.library.service.IBorrowingService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Transactional
@AllArgsConstructor
@Service
public class BorrowingImpl implements IBorrowingService {

    private BookRepository bookRepository;

    private PatronRepository patronRepository;

    private BorrowingRecordRepository borrowingRecordRepository;

    @Override
    public ResponseEntity<Void> borrowBook(Long bookId, Long patronId) {
        Optional<Book> book = bookRepository.findById(bookId);
        Optional<Patron> patron = patronRepository.findById(patronId);

        if (book.isPresent() && patron.isPresent()) {
            BorrowingRecord record = new BorrowingRecord();
            record.setBook(book.get());
            record.setPatron(patron.get());
            record.setBorrowDate(LocalDate.now());
            borrowingRecordRepository.save(record);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> returnBook(Long bookId, Long patronId) {
        Optional<BorrowingRecord> record = borrowingRecordRepository.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId);

        if (record.isPresent()) {
            BorrowingRecord existingRecord = record.get();
            existingRecord.setReturnDate(LocalDate.now());
            borrowingRecordRepository.save(existingRecord);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
