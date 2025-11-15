package vaga_junior.vaga_junior.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                    .title("Api REST Java")
                    .version("v1")
                    .description("Projeto API REST em Java para Vaga de Programador")
            );
    }
}
