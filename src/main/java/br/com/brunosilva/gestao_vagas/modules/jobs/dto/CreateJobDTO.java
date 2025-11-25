package br.com.brunosilva.gestao_vagas.modules.jobs.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class CreateJobDTO {

    @Schema(example = "Vaga para desenvolvedor junior", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "GYMPass, plano de saúde", requiredMode = RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "JUNIOR", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
