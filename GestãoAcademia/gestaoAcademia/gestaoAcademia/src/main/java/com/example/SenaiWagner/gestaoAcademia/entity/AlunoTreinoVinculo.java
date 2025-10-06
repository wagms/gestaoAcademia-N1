package com.example.SenaiWagner.gestaoAcademia.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ALUNO_TREINO_VINCULO")
public class AlunoTreinoVinculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataAssociacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treino_id", nullable = false)
    private Treino treino;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataAssociacao() { return dataAssociacao; }
    public void setDataAssociacao(LocalDateTime dataAssociacao) { this.dataAssociacao = dataAssociacao; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public Treino getTreino() { return treino; }
    public void setTreino(Treino treino) { this.treino = treino; }
}
