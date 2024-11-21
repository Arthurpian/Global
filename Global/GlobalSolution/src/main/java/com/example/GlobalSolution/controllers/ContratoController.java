package com.example.GlobalSolution.controllers;

import com.example.GlobalSolution.Services.ContratoService;
import com.example.GlobalSolution.entities.Contrato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping
    public ResponseEntity<Contrato> salvarContrato(@RequestBody Contrato contrato) {
        return ResponseEntity.ok(contratoService.salvarContrato(contrato));
    }

    @GetMapping("/{contrato_uuid}")
    public ResponseEntity<Contrato> buscarContrato(@PathVariable UUID contrato_uuid) {
        return ResponseEntity.ok(contratoService.buscarContrato(contrato_uuid));
    }

    @DeleteMapping("/{contrato_uuid}")
    public ResponseEntity<Contrato> desativarContrato(@PathVariable UUID contrato_uuid) {
        Contrato contrato = contratoService.buscarContrato(contrato_uuid);
        contrato.setAtivo(false);
        contratoService.salvarContrato(contrato);
        return ResponseEntity.ok(contrato);
    }
}
