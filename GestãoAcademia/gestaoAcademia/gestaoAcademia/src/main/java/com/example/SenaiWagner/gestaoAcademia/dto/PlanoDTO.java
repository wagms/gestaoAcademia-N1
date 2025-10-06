package com.example.SenaiWagner.gestaoAcademia.dto;

import java.math.BigDecimal;

public class PlanoDTO {
    private Long id;
    private String nome;
    private BigDecimal valorMensal;

    public PlanoDTO(Long id, String nome, BigDecimal valorMensal) {
        this.id = id;
        this.nome = nome;
        this.valorMensal = valorMensal;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public BigDecimal getValorMensal() { return valorMensal; }
    public void setValorMensal(BigDecimal valorMensal) { this.valorMensal = valorMensal; }
}
