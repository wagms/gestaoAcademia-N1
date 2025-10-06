package com.example.SenaiWagner.gestaoAcademia.controller;

import com.example.SenaiWagner.gestaoAcademia.dto.AlunoTreinoVinculoDTO;
import com.example.SenaiWagner.gestaoAcademia.service.AlunoTreinoVinculoService;
import com.example.SenaiWagner.gestaoAcademia.entity.AlunoTreinoVinculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vinculos")
public class AlunoTreinoVinculoController {

    @Autowired
    private AlunoTreinoVinculoService vinculoService;

    @GetMapping
    public ResponseEntity<List<AlunoTreinoVinculoDTO>> findAll() {
        List<AlunoTreinoVinculo> lista = vinculoService.findAll();
        List<AlunoTreinoVinculoDTO> dtos = lista.stream()
                .map(vinculoService::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<AlunoTreinoVinculoDTO> save(@RequestParam Long alunoId,
                                                      @RequestParam Long treinoId) {
        AlunoTreinoVinculo vinculo = vinculoService.save(alunoId, treinoId);
        return ResponseEntity.status(201).body(vinculoService.toDTO(vinculo));
    }
}
