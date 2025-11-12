package br.com.brunosilva.gestao_vagas.modules.jobs.useCases;

import br.com.brunosilva.gestao_vagas.modules.jobs.entities.JobEntity;
import br.com.brunosilva.gestao_vagas.modules.jobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }

}
