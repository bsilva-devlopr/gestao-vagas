package br.com.brunosilva.gestao_vagas.modules.candidate.controllers;

import br.com.brunosilva.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.brunosilva.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private static Logger LOGGER = LoggerFactory.getLogger(CandidateController.class);

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        LOGGER.info("Iniciando Candidate Controller");
        LOGGER.info("Candidato: {}", candidateEntity.getEmail());
        System.out.println("Candidato: " + candidateEntity.getEmail());

        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }
}
