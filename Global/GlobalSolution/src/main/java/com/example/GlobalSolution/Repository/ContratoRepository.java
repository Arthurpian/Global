package com.example.GlobalSolution.Repository;
import com.example.GlobalSolution.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface    ContratoRepository extends JpaRepository<Contrato, UUID> {

}