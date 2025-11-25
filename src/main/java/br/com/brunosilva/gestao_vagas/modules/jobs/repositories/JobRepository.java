package br.com.brunosilva.gestao_vagas.modules.jobs.repositories;

import br.com.brunosilva.gestao_vagas.modules.jobs.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

    // "contains - LIKE "

    // Select * from job where description like %filter%

    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
}
