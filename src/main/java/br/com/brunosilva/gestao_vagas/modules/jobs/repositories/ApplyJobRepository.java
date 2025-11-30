package br.com.brunosilva.gestao_vagas.modules.jobs.repositories;

import java.util.UUID;

import br.com.brunosilva.gestao_vagas.modules.jobs.entities.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {

}
