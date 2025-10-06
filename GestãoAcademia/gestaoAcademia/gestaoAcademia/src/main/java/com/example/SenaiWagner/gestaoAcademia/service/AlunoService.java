package com.example.SenaiWagner.gestaoAcademia.service;

import com.example.SenaiWagner.gestaoAcademia.dto.AlunoDTO;
import com.example.SenaiWagner.gestaoAcademia.entity.Aluno;
import com.example.SenaiWagner.gestaoAcademia.entity.Plano;
import com.example.SenaiWagner.gestaoAcademia.repository.AlunoRepository;
import com.example.SenaiWagner.gestaoAcademia.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PlanoRepository planoRepository;

    public Aluno findById(Long id) {
        return alunoRepository.findById(id).orElseThrow();
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno save(Aluno aluno, Long planoId) {
        if (planoId != null) {
            Plano plano = planoRepository.findById(planoId).orElseThrow();
            aluno.setPlano(plano);
        }
        aluno.setAtivo(true);
        return alunoRepository.save(aluno);
    }

    public Aluno update(Long id, Aluno dados, Long planoId) {
        Aluno aluno = findById(id);
        aluno.setNome(dados.getNome());
        aluno.setCpf(dados.getCpf());
        aluno.setDataNascimento(dados.getDataNascimento());

        if (planoId != null) {
            Plano plano = planoRepository.findById(planoId).orElseThrow();
            aluno.setPlano(plano);
        }

        return alunoRepository.save(aluno);
    }

    public void inativar(Long id) {
        Aluno aluno = findById(id);
        aluno.setAtivo(false);
        alunoRepository.save(aluno);
    }

    public void ativar(Long id) {
        Aluno aluno = findById(id);
        aluno.setAtivo(true);
        alunoRepository.save(aluno);
    }

    public AlunoDTO toDTO(Aluno aluno) {
        return new AlunoDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getDataNascimento(),
                aluno.isAtivo(),
                aluno.getPlano() != null ? aluno.getPlano().getId() : null
        );
    }
}
