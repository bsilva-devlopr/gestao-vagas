package br.com.brunosilva.gestao_vagas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoVagasApplication {

    private static final Logger logger = LoggerFactory.getLogger(GestaoVagasApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GestaoVagasApplication.class, args);
        logger.info("Sistema Gestão de Vagas - Aula Daniele Leão (Rocketseat)");
    }

}