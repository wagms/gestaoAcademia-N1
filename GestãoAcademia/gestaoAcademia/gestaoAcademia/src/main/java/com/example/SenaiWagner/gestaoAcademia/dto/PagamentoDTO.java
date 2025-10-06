package com.example.SenaiWagner.gestaoAcademia.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagamentoDTO {
    private Long id;
    private LocalDateTime dataPagamento;
    private BigDecimal valorPago;
    private String statusPagamento;
    private String formaPagamento;
    private Long alunoId;

    public PagamentoDTO(Long id, LocalDateTime dataPagamento, BigDecimal valorPago, String statusPagamento, String formaPagamento, Long alunoId) {
        this.id = id;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
        this.statusPagamento = statusPagamento;
        this.formaPagamento = formaPagamento;
        this.alunoId = alunoId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDateTime dataPagamento) { this.dataPagamento = dataPagamento; }

    public BigDecimal getValorPago() { return valorPago; }
    public void setValorPago(BigDecimal valorPago) { this.valorPago = valorPago; }

    public String getStatusPagamento() { return statusPagamento; }
    public void setStatusPagamento(String statusPagamento) { this.statusPagamento = statusPagamento; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
}
