package com.example.SenaiWagner.gestaoAcademia.controller;

import com.example.SenaiWagner.gestaoAcademia.dto.PagamentoDTO;
import com.example.SenaiWagner.gestaoAcademia.entity.Pagamento;
import com.example.SenaiWagner.gestaoAcademia.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pagamentoService.toDTO(pagamentoService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> findAll() {
        List<PagamentoDTO> pagamentos = pagamentoService.findAll()
                .stream()
                .map(pagamentoService::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pagamentos);
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> save(@RequestBody Pagamento pagamento,
                                             @RequestParam Long alunoId) {
        Pagamento criado = pagamentoService.save(pagamento, alunoId);
        return ResponseEntity.status(201).body(pagamentoService.toDTO(criado));
    }
}
