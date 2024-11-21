package com.example.GlobalSolution.controllers;

import com.example.GlobalSolution.Services.InstalacaoService;
import com.example.GlobalSolution.entities.Instalacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/instalacoes")
public class InstalacaoController {

    private final InstalacaoService instalacaoService;

    public InstalacaoController(InstalacaoService instalacaoService) {
        this.instalacaoService = instalacaoService;
    }

    @PostMapping
    public ResponseEntity<Instalacao> salvarInstalacao(@RequestBody Instalacao instalacao) {
        return ResponseEntity.ok(instalacaoService.salvarInstalacao(instalacao));
    }

    @GetMapping("/{instalacao_uuid}")
    public ResponseEntity<Instalacao> buscarInstalacao(@PathVariable UUID instalacao_uuid) {
        return ResponseEntity.ok(instalacaoService.buscarInstalacao(instalacao_uuid));
    }

    @GetMapping
    public ResponseEntity<List<Instalacao>> listarInstalacoes() {
        return ResponseEntity.ok(instalacaoService.listarInstalacoes());
    }

    @DeleteMapping("/{instalacao_uuid}")
    public ResponseEntity<Instalacao> desativarInstalacao(@PathVariable UUID instalacao_uuid) {
        instalacaoService.desativarInstalacao(instalacao_uuid);
        Instalacao instalacaoDesativada = instalacaoService.buscarInstalacao(instalacao_uuid);
        return ResponseEntity.ok(instalacaoDesativada);
    }
}
