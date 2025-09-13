package br.com.brunosilva.gestao_vagas.modules.company.controllers;

import br.com.brunosilva.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.brunosilva.gestao_vagas.modules.company.useCases.CreateCompanyUseCase;
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
@RequestMapping("/company")
public class CompanyController {

  private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

  @Autowired
  private CreateCompanyUseCase createCompanyUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
    try {
      var result = this.createCompanyUseCase.execute(companyEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      logger.error("Erro ao criar a empresa: ", e);
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }
}
