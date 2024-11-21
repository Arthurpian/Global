package com.example.GlobalSolution.Repository;

import com.example.GlobalSolution.entities.RegistroProducao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RegistroProducaoRepository extends JpaRepository<RegistroProducao, UUID> {

    List<RegistroProducao> findByContrato_ContratoUuid(UUID contratoUuid);
}
