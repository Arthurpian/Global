package com.example.GlobalSolution.controllers;

import com.example.GlobalSolution.Services.RegistroProducaoService;
import com.example.GlobalSolution.entities.RegistroProducao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/producao")
public class RegistroProducaoController {

    private final RegistroProducaoService registroProducaoService;

    public RegistroProducaoController(RegistroProducaoService registroProducaoService) {
        this.registroProducaoService = registroProducaoService;
    }

    @PostMapping
    public ResponseEntity<RegistroProducao> salvarRegistroProducao(@RequestBody RegistroProducao registroProducao) {
        return ResponseEntity.ok(registroProducaoService.salvarRegistroProducao(registroProducao));
    }

    @GetMapping("/{contrato_uuid}")
    public ResponseEntity<List<RegistroProducao>> listarRegistros(@PathVariable UUID contrato_uuid) {
        return ResponseEntity.ok(registroProducaoService.listarRegistrosPorContrato(contrato_uuid));
    }
}
