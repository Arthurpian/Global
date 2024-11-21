package com.example.GlobalSolution.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class RegistroProducao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID registroProducaoUuid;

    @ManyToOne
    @JoinColumn(name = "contrato_uuid", nullable = false)
    private Contrato contrato;

    @Column(name = "producao_kwh", nullable = false)
    private double producaoKWh;

    @Column(nullable = false)
    private long medicaoTimestamp;

    // Construtor
    public RegistroProducao() {
        this.registroProducaoUuid = UUID.randomUUID();
    }

    public UUID getRegistroProducaoUuid() {
        return registroProducaoUuid;
    }

    public void setRegistroProducaoUuid(UUID registroProducaoUuid) {
        this.registroProducaoUuid = registroProducaoUuid;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public double getProducaoKWh() {
        return producaoKWh;
    }

    public void setProducaoKWh(double producaoKWh) {
        if (producaoKWh < 0) {
            throw new IllegalArgumentException("A produção de energia não pode ser negativa.");
        }
        this.producaoKWh = producaoKWh;
    }

    public long getMedicaoTimestamp() {
        return medicaoTimestamp;
    }

    public void setMedicaoTimestamp(long medicaoTimestamp) {
        this.medicaoTimestamp = medicaoTimestamp;
    }

    @Override
    public String toString() {
        return "RegistroProducao{" +
                "registroProducaoUuid=" + registroProducaoUuid +
                ", contrato=" + contrato +
                ", producaoKWh=" + producaoKWh +
                ", medicaoTimestamp=" + medicaoTimestamp +
                '}';
    }
}
