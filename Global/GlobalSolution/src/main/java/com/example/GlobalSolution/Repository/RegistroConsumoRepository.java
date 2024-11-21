package com.example.GlobalSolution.Repository;

import com.example.GlobalSolution.entities.RegistroConsumo;
import com.example.GlobalSolution.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface    RegistroConsumoRepository extends JpaRepository<RegistroConsumo, UUID> {
    List<RegistroConsumo> findByContrato(Contrato contrato);
}
