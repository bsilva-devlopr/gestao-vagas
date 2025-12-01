package br.com.brunosilva.gestao_vagas.modules.jobs.useCases;

import br.com.brunosilva.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.brunosilva.gestao_vagas.modules.company.repositories.CompanyRepository;
import br.com.brunosilva.gestao_vagas.modules.jobs.entities.JobEntity;
import br.com.brunosilva.gestao_vagas.modules.jobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.jobRepository.save(jobEntity);
    }

}
