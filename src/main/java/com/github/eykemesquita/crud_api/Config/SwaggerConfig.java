package com.github.eykemesquita.crud_api.Config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuração do Swagger para documentar a API.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .servers(serversList()) // Lista de servidores usando a classe correta
                .tags(apiTags())
                .components(apiComponents())
                .security(List.of(new SecurityRequirement().addList("bearerAuth")));
    }

    private Info apiInfo() {
        return new Info()
                .title("Documentação da API CRUD - v1.0")
                .version("1.0")
                .description("API para gestão de clientes, com paginação e filtragem")
                .contact(new Contact().name("Suporte API").email("support@example.com"))
                .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html"));
    }

    private List<Server> serversList() {
        return List.of(
                new Server().url("http://localhost:8080").description("Servidor Local"),
                new Server().url("https://staging-api.example.com").description("Servidor de Homologação"),
                new Server().url("https://api.example.com/v1").description("Servidor de Produção")
        );
    }

    private List<Tag> apiTags() {
        return List.of(new Tag().name("Clients").description("Operações relacionadas a clientes"));
    }

    private Components apiComponents() {
        return new Components()
                .addResponses("404", createApiResponse("Recurso não encontrado"))
                .addResponses("500", createApiResponse("Erro interno do servidor"))
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT"));
    }

    private ApiResponse createApiResponse(String description) {
        return new ApiResponse().description(description);
    }
}
