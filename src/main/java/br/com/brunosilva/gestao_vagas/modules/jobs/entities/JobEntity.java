package br.com.brunosilva.gestao_vagas.modules.jobs.entities;

import br.com.brunosilva.gestao_vagas.modules.company.entities.CompanyEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "job")
@Data
public class JobEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID uuid;
  private String description;
  private String benefits;

  @NotBlank(message = "Esse campo é obrigatório")
  private String level;

  // Chave estrangeira para criar o vinculo com a tabela da company
  @ManyToOne() // Muitos jobs para uma company
  @JoinColumn(name = "company_id", insertable = false, updatable = false)
  private CompanyEntity companyEntity;

  // (insertable = false, updatable = false) O ORM vai entender que é para usar somente o companyId
  @Column(name = "company_id", nullable = false)
  private UUID companyId;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
