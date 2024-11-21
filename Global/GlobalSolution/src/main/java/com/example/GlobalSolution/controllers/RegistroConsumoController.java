package com.example.GlobalSolution.controllers;

import com.example.GlobalSolution.Services.RegistroConsumoService;
import com.example.GlobalSolution.entities.RegistroConsumo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consumo") // Coloque /cosumo/(CONTRATO_UUID)
public class RegistroConsumoController {

    private final RegistroConsumoService registroConsumoService;

    public RegistroConsumoController(RegistroConsumoService registroConsumoService) {
        this.registroConsumoService = registroConsumoService;
    }

    @PostMapping
    public ResponseEntity<RegistroConsumo> salvarRegistroConsumo(@RequestBody RegistroConsumo registroConsumo) {
        return ResponseEntity.ok(registroConsumoService.salvarRegistroConsumo(registroConsumo));
    }

    @GetMapping("/{contrato_uuid}")
    public ResponseEntity<List<RegistroConsumo>> listarRegistros(@PathVariable UUID contrato_uuid) {
        return ResponseEntity.ok(registroConsumoService.buscarPorContrato(contrato_uuid));
    }
}
