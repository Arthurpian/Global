    package com.example.GlobalSolution.Services;

    import com.example.GlobalSolution.entities.Cliente;
    import com.example.GlobalSolution.Repository.ClienteRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.UUID;

    @Service
    public class ClienteService {

        private final ClienteRepository clienteRepository;

        public ClienteService(ClienteRepository clienteRepository) {
            this.clienteRepository = clienteRepository;
        }

        public Cliente salvarCliente(Cliente cliente) {
            return clienteRepository.save(cliente);
        }

        public Cliente buscarCliente(UUID clienteUuid) {
            return clienteRepository.findById(clienteUuid)
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        }

        public List<Cliente> listarClientes() {
            return clienteRepository.findAll();
        }


        public void desativarCliente(UUID clienteUuid) {
            Cliente cliente = clienteRepository.findById(clienteUuid)
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            cliente.setAtivo(false);
            clienteRepository.save(cliente);
        }
    }
