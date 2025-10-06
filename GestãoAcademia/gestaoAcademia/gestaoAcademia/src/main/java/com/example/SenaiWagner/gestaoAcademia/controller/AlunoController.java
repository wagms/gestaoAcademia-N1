package com.example.SenaiWagner.gestaoAcademia.controller;

import com.example.SenaiWagner.gestaoAcademia.dto.AlunoDTO;
import com.example.SenaiWagner.gestaoAcademia.entity.Aluno;
import com.example.SenaiWagner.gestaoAcademia.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable Long id) {
        AlunoDTO alunoDTO = alunoService.toDTO(alunoService.findById(id));
        return ResponseEntity.ok(alunoDTO);
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> findAll() {
        List<AlunoDTO> alunos = alunoService.findAll()
                .stream()
                .map(alunoService::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> save(@RequestBody Aluno aluno,
                                         @RequestParam(required = false) Long planoId) {
        Aluno alunoCriado = alunoService.save(aluno, planoId);
        return ResponseEntity.status(201).body(alunoService.toDTO(alunoCriado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> update(@PathVariable Long id,
                                           @RequestBody Aluno aluno,
                                           @RequestParam(required = false) Long planoId) {
        Aluno alunoAtualizado = alunoService.update(id, aluno, planoId);
        return ResponseEntity.ok(alunoService.toDTO(alunoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        alunoService.inativar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/ativar")
    public ResponseEntity<Void> ativar(@PathVariable Long id) {
        alunoService.ativar(id);
        return ResponseEntity.noContent().build();
    }
}
