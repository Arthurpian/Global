package com.example.GlobalSolution.controllers;

import com.example.GlobalSolution.Services.ClienteService;
import com.example.GlobalSolution.entities.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.salvarCliente(cliente));
    }

    @GetMapping("/{cliente_uuid}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable UUID cliente_uuid) {
        return ResponseEntity.ok(clienteService.buscarCliente(cliente_uuid));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @DeleteMapping("/{clienteUuid}")
    public ResponseEntity<Void> deletarCliente(@PathVariable UUID clienteUuid) {
        clienteService.desativarCliente(clienteUuid); // Deleção lógica
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
