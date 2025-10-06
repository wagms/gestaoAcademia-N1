package com.example.SenaiWagner.gestaoAcademia.controller;

import com.example.SenaiWagner.gestaoAcademia.dto.TreinoDTO;
import com.example.SenaiWagner.gestaoAcademia.entity.Treino;
import com.example.SenaiWagner.gestaoAcademia.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @GetMapping("/{id}")
    public ResponseEntity<TreinoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(treinoService.toDTO(treinoService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<TreinoDTO>> findAll() {
        List<TreinoDTO> treinos = treinoService.findAll()
                .stream()
                .map(treinoService::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(treinos);
    }

    @PostMapping
    public ResponseEntity<TreinoDTO> save(@RequestBody Treino treino) {
        Treino criado = treinoService.save(treino);
        return ResponseEntity.status(201).body(treinoService.toDTO(criado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoDTO> update(@PathVariable Long id, @RequestBody Treino treino) {
        Treino atualizado = treinoService.update(id, treino);
        return ResponseEntity.ok(treinoService.toDTO(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        treinoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
