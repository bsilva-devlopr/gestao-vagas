package br.com.brunosilva.gestao_vagas.modules.jobs.useCases;

import br.com.brunosilva.gestao_vagas.modules.jobs.entities.JobEntity;
import br.com.brunosilva.gestao_vagas.modules.jobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter) {
        return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
    }
}
