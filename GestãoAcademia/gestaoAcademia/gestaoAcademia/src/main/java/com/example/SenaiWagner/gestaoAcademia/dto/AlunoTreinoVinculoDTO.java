package com.example.SenaiWagner.gestaoAcademia.dto;

import java.time.LocalDateTime;

public class AlunoTreinoVinculoDTO {
    private Long id;
    private Long alunoId;
    private Long treinoId;
    private LocalDateTime dataAssociacao;

    public AlunoTreinoVinculoDTO(Long id, Long alunoId, Long treinoId, LocalDateTime dataAssociacao) {
        this.id = id;
        this.alunoId = alunoId;
        this.treinoId = treinoId;
        this.dataAssociacao = dataAssociacao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }

    public Long getTreinoId() { return treinoId; }
    public void setTreinoId(Long treinoId) { this.treinoId = treinoId; }

    public LocalDateTime getDataAssociacao() { return dataAssociacao; }
    public void setDataAssociacao(LocalDateTime dataAssociacao) { this.dataAssociacao = dataAssociacao; }
}
