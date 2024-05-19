package com.libarary.library.controller;


import com.libarary.library.model.Patron;
import com.libarary.library.service.IPatronService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Cache-Control, Content-Language, Content-Type, Expires, Last-Modified")
@AllArgsConstructor
@RestController
@RequestMapping("/api/patrons")
public class PatronController {


    private IPatronService iPatronService;

    @GetMapping
    public ResponseEntity<?> getAllPatrons() {
        return new ResponseEntity<>(iPatronService.getAllPatrons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatronById(@PathVariable Long id) {
        return iPatronService.getPatronById(id);
    }

    @PostMapping
    public ResponseEntity<?> createPatron(@RequestBody Patron patron) {
        return new ResponseEntity<>(iPatronService.createPatron(patron), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatron(@PathVariable Long id, @RequestBody Patron updatedPatron) {
        return iPatronService.updatePatron(id, updatedPatron);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatron(@PathVariable Long id) {
        return iPatronService.deletePatron(id);
    }
}
