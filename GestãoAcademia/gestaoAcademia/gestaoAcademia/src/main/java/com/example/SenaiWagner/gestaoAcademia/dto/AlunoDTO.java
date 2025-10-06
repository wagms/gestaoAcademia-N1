package com.example.SenaiWagner.gestaoAcademia.dto;

import java.time.LocalDate;

public class AlunoDTO {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private boolean ativo;
    private Long planoId;

    public AlunoDTO(Long id, String nome, String cpf, LocalDate dataNascimento, boolean ativo, Long planoId) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
        this.planoId = planoId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public Long getPlanoId() { return planoId; }
    public void setPlanoId(Long planoId) { this.planoId = planoId; }
}
