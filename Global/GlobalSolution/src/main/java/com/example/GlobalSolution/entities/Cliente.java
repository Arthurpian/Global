package com.example.GlobalSolution.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Cliente {

    @Id
    private UUID clienteUuid;
    private String name;
    private String endereco;
    private String cpfCnpj;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    private String cep;
    private Boolean ativo;

    public Cliente() {
        this.clienteUuid = UUID.randomUUID();
        this.ativo = true;
    }

    public UUID getClienteUuid() {
        return clienteUuid;
    }

    public void setClienteUuid(UUID clienteUuid) {
        this.clienteUuid = clienteUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
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
