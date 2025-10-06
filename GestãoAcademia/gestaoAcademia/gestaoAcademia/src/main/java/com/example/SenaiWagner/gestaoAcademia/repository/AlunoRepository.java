package com.example.SenaiWagner.gestaoAcademia.repository;

import com.example.SenaiWagner.gestaoAcademia.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
