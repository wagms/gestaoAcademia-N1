package com.example.SenaiWagner.gestaoAcademia.service;

import com.example.SenaiWagner.gestaoAcademia.dto.PagamentoDTO;
import com.example.SenaiWagner.gestaoAcademia.entity.Aluno;
import com.example.SenaiWagner.gestaoAcademia.entity.Pagamento;
import com.example.SenaiWagner.gestaoAcademia.repository.AlunoRepository;
import com.example.SenaiWagner.gestaoAcademia.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public Pagamento findById(Long id) {
        return pagamentoRepository.findById(id).orElseThrow();
    }

    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

    public Pagamento save(Pagamento pagamento, Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        pagamento.setAluno(aluno);
        pagamento.setDataPagamento(LocalDateTime.now());
        return pagamentoRepository.save(pagamento);
    }

    public PagamentoDTO toDTO(Pagamento pagamento) {
        return new PagamentoDTO(
                pagamento.getId(),
                pagamento.getDataPagamento(),
                pagamento.getValorPago(),
                pagamento.getStatusPagamento(),
                pagamento.getFormaPagamento(),
                pagamento.getAluno() != null ? pagamento.getAluno().getId() : null
        );
    }
}
