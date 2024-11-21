package com.example.GlobalSolution.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Contrato {

    @Id
    private UUID contratoUuid;

    @ManyToOne
    @JoinColumn(name = "cliente_uuid", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "instalacao_uuid", nullable = false)
    private Instalacao instalacao;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private int duracaoContrato;

    @Column(nullable = false)
    private Boolean ativo;

    public Contrato() {
        this.contratoUuid = UUID.randomUUID();
        this.ativo = true;
    }

    public void setDuracaoContrato(int duracaoContrato) {
        if (duracaoContrato % 90 != 0 || duracaoContrato < 90 || duracaoContrato > 810) {
            throw new IllegalArgumentException("A duração do contrato deve ser múltipla de 90 dias entre 90 e 810 dias.");
        }
        this.duracaoContrato = duracaoContrato;
    }

    public UUID getContratoUuid() {
        return contratoUuid;
    }

    public void setContratoUuid(UUID contratoUuid) {
        this.contratoUuid = contratoUuid;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Instalacao getInstalacao() {
        return instalacao;
    }

    public void setInstalacao(Instalacao instalacao) {
        this.instalacao = instalacao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDuracaoContrato() {
        return duracaoContrato;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
