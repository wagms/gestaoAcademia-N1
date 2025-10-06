package com.example.SenaiWagner.gestaoAcademia.service;

import com.example.SenaiWagner.gestaoAcademia.dto.AlunoTreinoVinculoDTO;
import com.example.SenaiWagner.gestaoAcademia.entity.Aluno;
import com.example.SenaiWagner.gestaoAcademia.entity.AlunoTreinoVinculo;
import com.example.SenaiWagner.gestaoAcademia.entity.Treino;
import com.example.SenaiWagner.gestaoAcademia.repository.AlunoRepository;
import com.example.SenaiWagner.gestaoAcademia.repository.AlunoTreinoVinculoRepository;
import com.example.SenaiWagner.gestaoAcademia.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlunoTreinoVinculoService {

    @Autowired
    private AlunoTreinoVinculoRepository vinculoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TreinoRepository treinoRepository;

    public List<AlunoTreinoVinculo> findAll() {
        return vinculoRepository.findAll();
    }

    public AlunoTreinoVinculo save(Long alunoId, Long treinoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        Treino treino = treinoRepository.findById(treinoId).orElseThrow();

        AlunoTreinoVinculo vinculo = new AlunoTreinoVinculo();
        vinculo.setAluno(aluno);
        vinculo.setTreino(treino);
        vinculo.setDataAssociacao(LocalDateTime.now());

        return vinculoRepository.save(vinculo);
    }

    public AlunoTreinoVinculoDTO toDTO(AlunoTreinoVinculo vinculo) {
        return new AlunoTreinoVinculoDTO(
                vinculo.getId(),
                vinculo.getAluno() != null ? vinculo.getAluno().getId() : null,
                vinculo.getTreino() != null ? vinculo.getTreino().getId() : null,
                vinculo.getDataAssociacao()
        );
    }
}
