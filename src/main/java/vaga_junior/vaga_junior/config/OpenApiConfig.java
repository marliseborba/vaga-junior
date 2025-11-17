package vaga_junior.vaga_junior.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    // Define informações sobre a API para o Swagger
    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                    .title("Api REST Java")
                    .description("Projeto API REST em Java para Vaga de Programador")
            );
    }
}
