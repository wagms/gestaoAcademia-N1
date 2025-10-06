package com.example.SenaiWagner.gestaoAcademia.controller;

import com.example.SenaiWagner.gestaoAcademia.dto.PlanoDTO;
import com.example.SenaiWagner.gestaoAcademia.entity.Plano;
import com.example.SenaiWagner.gestaoAcademia.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> findAll() {
        List<PlanoDTO> lista = planoService.findAll()
                .stream()
                .map(planoService::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(planoService.toDTO(planoService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<PlanoDTO> save(@RequestBody Plano plano) {
        Plano criado = planoService.save(plano);
        return ResponseEntity.status(201).body(planoService.toDTO(criado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDTO> update(@PathVariable Long id, @RequestBody Plano plano) {
        Plano atualizado = planoService.update(id, plano);
        return ResponseEntity.ok(planoService.toDTO(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        planoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
