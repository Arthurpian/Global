package com.example.GlobalSolution.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class RegistroConsumo {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "contrato_uuid", nullable = false)
    private Contrato contrato;

    private double consumoKwh;
    private long medicaoTimestamp;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public double getConsumoKwh() {  // Nome corrigido
        return consumoKwh;
    }

    public void setConsumoKwh(double consumoKwh) {
        this.consumoKwh = consumoKwh;
    }

    public long getMedicaoTimestamp() {
        return medicaoTimestamp;
    }

    public void setMedicaoTimestamp(long medicaoTimestamp) {
        this.medicaoTimestamp = medicaoTimestamp;
    }
}
