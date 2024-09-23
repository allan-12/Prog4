package com.example.prog4.Controlleur;

import com.example.prog4.Service.PatrimoineService;
import com.example.prog4.model.Patrimoine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
    @RequestMapping("/patrimoines")
public class PatrimoineController {
    private final PatrimoineService patrimoineService;

    public PatrimoineController(PatrimoineService patrimoineService) {
        this.patrimoineService = patrimoineService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> createOrUpdatePatrimoine(@PathVariable String id, @RequestBody Patrimoine patrimoine) {
        try {
            patrimoineService.saveOrUpdatePatrimoine(id, patrimoine);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patrimoine> getPatrimoine(@PathVariable String id) {
        try {
            Patrimoine patrimoine = patrimoineService.getPatrimoine(id);
            if (patrimoine != null) {
                return ResponseEntity.ok(patrimoine);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    }





