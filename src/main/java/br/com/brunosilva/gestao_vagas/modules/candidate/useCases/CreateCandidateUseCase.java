package br.com.brunosilva.gestao_vagas.modules.candidate.useCases;

import br.com.brunosilva.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.brunosilva.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import br.com.brunosilva.gestao_vagas.modules.errors.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository
            .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
            .ifPresent((user) -> {
              throw new UserFoundException();
            });
    return this.candidateRepository.save(candidateEntity);
  }
}
