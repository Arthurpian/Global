package com.example.GlobalSolution.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Instalacao {

    @Id
    private UUID instalacaoUuid;

    @ManyToOne
    @JoinColumn(name = "cliente_uuid", nullable = false)
    private Cliente cliente;

    private String endereco;
    private String cep;
    private Boolean ativo;

    public Instalacao() {
        this.instalacaoUuid = UUID.randomUUID();
        this.ativo = true;
    }

    public UUID getInstalacaoUuid() {
        return instalacaoUuid;
    }

    public void setInstalacaoUuid(UUID instalacaoUuid) {
        this.instalacaoUuid = instalacaoUuid;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
