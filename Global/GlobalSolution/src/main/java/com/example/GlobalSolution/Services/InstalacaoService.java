package com.example.GlobalSolution.Services;

import com.example.GlobalSolution.entities.Instalacao;
import com.example.GlobalSolution.Repository.InstalacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InstalacaoService {

    private final InstalacaoRepository instalacaoRepository;

    public InstalacaoService(InstalacaoRepository instalacaoRepository) {
        this.instalacaoRepository = instalacaoRepository;
    }

    public Instalacao salvarInstalacao(Instalacao instalacao) {
        return instalacaoRepository.save(instalacao);
    }

    public Instalacao buscarInstalacao(UUID instalacaoUuid) {
        return instalacaoRepository.findById(instalacaoUuid)
                .orElseThrow(() -> new RuntimeException("Instalação não encontrada"));
    }

    public List<Instalacao> listarInstalacoes() {
        return instalacaoRepository.findAll();
    }

    public void desativarInstalacao(UUID instalacaoUuid) {
        Instalacao instalacao = buscarInstalacao(instalacaoUuid);
        instalacao.setAtivo(false);
        instalacaoRepository.save(instalacao);
    }
}
