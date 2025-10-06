package com.example.SenaiWagner.gestaoAcademia.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_TREINO")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @Column(nullable = false)
    private String nivel;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL)
    private List<AlunoTreinoVinculo> alunos;

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public List<AlunoTreinoVinculo> getAlunos() { return alunos; }
    public void setAlunos(List<AlunoTreinoVinculo> alunos) { this.alunos = alunos; }
}
