package com.libarary.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BorrowingRecord")
public class BorrowingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;

    private LocalDate borrowDate;
    private LocalDate returnDate;

}
