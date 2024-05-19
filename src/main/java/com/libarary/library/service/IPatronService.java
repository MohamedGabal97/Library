package com.libarary.library.service;


import com.libarary.library.model.Patron;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPatronService {

    List<Patron> getAllPatrons() ;

    ResponseEntity<Patron> getPatronById(Long id);

    Patron createPatron(Patron patron);

    ResponseEntity<Patron> updatePatron(Long id, Patron updatedPatron);

    ResponseEntity<Void> deletePatron(Long id);

}
