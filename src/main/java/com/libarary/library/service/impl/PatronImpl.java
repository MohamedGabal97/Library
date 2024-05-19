package com.libarary.library.service.impl;


import com.libarary.library.model.Patron;
import com.libarary.library.repository.PatronRepository;
import com.libarary.library.service.IPatronService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class PatronImpl implements IPatronService {

    private PatronRepository patronRepository;

    @Override
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @Override
    public ResponseEntity<Patron> getPatronById(Long id) {
        return patronRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public Patron createPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    @Override
    public ResponseEntity<Patron> updatePatron(Long id, Patron updatedPatron) {
        return patronRepository.findById(id)
                .map(patron -> {
                    patron.setName(updatedPatron.getName());
                    patron.setContactInformation(updatedPatron.getContactInformation());
                    return ResponseEntity.ok(patronRepository.save(patron));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deletePatron(Long id) {
        return patronRepository.findById(id)
                .map(patron -> {
                    patronRepository.delete(patron);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
