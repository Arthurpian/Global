package com.example.GlobalSolution.Services;

import com.example.GlobalSolution.Repository.RegistroProducaoRepository;
import com.example.GlobalSolution.entities.RegistroProducao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegistroProducaoService {

    private final RegistroProducaoRepository registroProducaoRepository;

    public RegistroProducaoService(RegistroProducaoRepository registroProducaoRepository) {
        this.registroProducaoRepository = registroProducaoRepository;
    }

    public RegistroProducao salvarRegistroProducao(RegistroProducao registroProducao) {
        validarRegistroProducao(registroProducao);
        return registroProducaoRepository.save(registroProducao);
    }

    public List<RegistroProducao> listarRegistrosPorContrato(UUID contratoUuid) {
        return registroProducaoRepository.findByContrato_ContratoUuid(contratoUuid);
    }

    private void validarRegistroProducao(RegistroProducao novoRegistro) {
        List<RegistroProducao> registros = registroProducaoRepository.findByContrato_ContratoUuid(novoRegistro.getContrato().getContratoUuid());
        if (!registros.isEmpty()) {
            RegistroProducao ultimoRegistro = registros.get(registros.size() - 1);
            if (novoRegistro.getProducaoKWh() <= ultimoRegistro.getProducaoKWh()) {
                throw new IllegalArgumentException("A produção kWh deve ser maior que o último registro.");
            }
            if (novoRegistro.getMedicaoTimestamp() <= ultimoRegistro.getMedicaoTimestamp()) {
                throw new IllegalArgumentException("O timestamp deve ser posterior ao último registro.");
            }
        }
    }
}
