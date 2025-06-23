package com.project.emprestimos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmprestimoResponseDTO {

    private Long id;
    private String cliente;
    private BigDecimal valor;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    // Construtor
    public EmprestimoResponseDTO(Long id, String cliente, BigDecimal valor, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    // Getters
    public Long getId() { return id; }
    public String getCliente() { return cliente; }
    public BigDecimal getValor() { return valor; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
}
