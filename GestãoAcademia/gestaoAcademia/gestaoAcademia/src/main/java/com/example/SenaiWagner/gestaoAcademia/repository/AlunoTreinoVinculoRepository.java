package com.example.SenaiWagner.gestaoAcademia.repository;

import com.example.SenaiWagner.gestaoAcademia.entity.AlunoTreinoVinculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoTreinoVinculoRepository extends JpaRepository<AlunoTreinoVinculo, Long> {
    boolean existsByTreinoId(Long id);
}
