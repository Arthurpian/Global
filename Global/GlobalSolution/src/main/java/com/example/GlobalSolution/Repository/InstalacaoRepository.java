package com.example.GlobalSolution.Repository;
import com.example.GlobalSolution.entities.Instalacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface InstalacaoRepository extends JpaRepository<Instalacao, UUID> {

}