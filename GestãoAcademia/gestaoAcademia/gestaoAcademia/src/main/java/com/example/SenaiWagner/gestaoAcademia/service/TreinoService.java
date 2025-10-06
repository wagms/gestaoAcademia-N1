package com.example.SenaiWagner.gestaoAcademia.service;

import com.example.SenaiWagner.gestaoAcademia.dto.TreinoDTO;
import com.example.SenaiWagner.gestaoAcademia.entity.Treino;
import com.example.SenaiWagner.gestaoAcademia.repository.AlunoTreinoVinculoRepository;
import com.example.SenaiWagner.gestaoAcademia.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private AlunoTreinoVinculoRepository alunoTreinoVinculoRepository;

    public Treino findById(Long id) {
        return treinoRepository.findById(id).orElseThrow();
    }

    public List<Treino> findAll() {
        return treinoRepository.findAll();
    }

    public Treino save(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Treino update(Long id, Treino dados) {
        Treino treino = findById(id);
        treino.setNome(dados.getNome());
        treino.setDescricao(dados.getDescricao());
        treino.setNivel(dados.getNivel());
        return treinoRepository.save(treino);
    }

    public void delete(Long id) {
        boolean vinculado = alunoTreinoVinculoRepository.existsByTreinoId(id);
        if (vinculado) {
            throw new RuntimeException("Treino vinculado a alunos");
        }
        treinoRepository.deleteById(id);
    }

    public TreinoDTO toDTO(Treino treino) {
        return new TreinoDTO(
                treino.getId(),
                treino.getNome(),
                treino.getDescricao(),
                treino.getNivel()
        );
    }
}
