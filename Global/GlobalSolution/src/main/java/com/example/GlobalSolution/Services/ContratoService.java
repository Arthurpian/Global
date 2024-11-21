package com.example.GlobalSolution.Services;

import com.example.GlobalSolution.Repository.ContratoRepository;
import com.example.GlobalSolution.entities.Contrato;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public Contrato salvarContrato(Contrato contrato) {
        verificarContratoUnico(contrato);
        return contratoRepository.save(contrato);
    }

    public Contrato buscarContrato(UUID contratoUuid) {
        return contratoRepository.findById(contratoUuid)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }

    public void verificarContratosExpirados() {
        List<Contrato> contratos = contratoRepository.findAll();
        contratos.stream()
                .filter(c -> c.getAtivo() && c.getDataInicio().plusDays(c.getDuracaoContrato()).isBefore(LocalDate.now()))
                .forEach(c -> {
                    c.setAtivo(false);
                    contratoRepository.save(c);
                });
    }

    private void verificarContratoUnico(Contrato contrato) {
        boolean contratoExistente = contratoRepository.findAll().stream()
                .anyMatch(c -> c.getCliente().equals(contrato.getCliente())
                        && c.getInstalacao().equals(contrato.getInstalacao())
                        && c.getAtivo());
        if (contratoExistente) {
            throw new IllegalArgumentException("Cliente e instalação já possuem contrato ativo.");
        }
    }
}
