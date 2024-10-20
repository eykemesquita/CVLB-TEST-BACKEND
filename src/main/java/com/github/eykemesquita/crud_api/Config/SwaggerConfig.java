package com.github.eykemesquita.crud_api.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Client Documentation")
                        .version("1.0")
                        .description("Documentação da API para o projeto de CRUD"));
    }
}

//Acessar a documentação Swagger na seguinte URL:http://localhost:8080/swagger-ui.html
