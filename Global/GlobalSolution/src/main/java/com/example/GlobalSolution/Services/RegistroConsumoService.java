package com.example.GlobalSolution.Services;

import com.example.GlobalSolution.Repository.RegistroConsumoRepository;
import com.example.GlobalSolution.entities.RegistroConsumo;
import com.example.GlobalSolution.entities.Contrato;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegistroConsumoService {

    private final RegistroConsumoRepository registroConsumoRepository;
    private final ContratoService contratoService;

    public RegistroConsumoService(RegistroConsumoRepository registroConsumoRepository, ContratoService contratoService) {
        this.registroConsumoRepository = registroConsumoRepository;
        this.contratoService = contratoService;
    }

    public RegistroConsumo salvarRegistroConsumo(RegistroConsumo registroConsumo) {
        return registroConsumoRepository.save(registroConsumo);
    }

    public List<RegistroConsumo> buscarPorContrato(UUID contratoUuid) {
        Contrato contrato = contratoService.buscarContrato(contratoUuid);
        return registroConsumoRepository.findByContrato(contrato);
    }

    public double calcularConsumoTotal(UUID contratoUuid) {
        List<RegistroConsumo> registros = buscarPorContrato(contratoUuid);

        return registros.stream()
                .mapToDouble(RegistroConsumo::getConsumoKwh)
                .sum();
    }
}
