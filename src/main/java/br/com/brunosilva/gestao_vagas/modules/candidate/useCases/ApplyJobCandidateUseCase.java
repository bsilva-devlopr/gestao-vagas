package br.com.brunosilva.gestao_vagas.modules.candidate.useCases;

import br.com.brunosilva.gestao_vagas.exceptions.JobNotFoundException;
import br.com.brunosilva.gestao_vagas.exceptions.UserFoundException;
import br.com.brunosilva.gestao_vagas.exceptions.UserNotFoundException;
import br.com.brunosilva.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import br.com.brunosilva.gestao_vagas.modules.jobs.entities.ApplyJobEntity;
import br.com.brunosilva.gestao_vagas.modules.jobs.repositories.ApplyJobRepository;
import br.com.brunosilva.gestao_vagas.modules.jobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    // ID do Candidato
    // ID da vaga
    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        // Validar se o candidato existe
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        // Validar se a vaga existe
        this.jobRepository.findById(idJob)
                .orElseThrow(() -> {
                    throw new JobNotFoundException();
                });

        // Candidato se inscrever na vaga
        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob).build();

        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }
}
