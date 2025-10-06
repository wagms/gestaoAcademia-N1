package com.example.SenaiWagner.gestaoAcademia.dto;

public class TreinoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String nivel;

    public TreinoDTO(Long id, String nome, String descricao, String nivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.nivel = nivel;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
}
