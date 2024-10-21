package com.github.eykemesquita.crud_api.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CRUD API Documentation - v1.0")
                        .version("1.0")
                        .description("API for managing clients, including features such as pagination and filtering")
                        .termsOfService("https://example.com/terms")
                        .contact(new Contact()
                                .name("API Support")
                                .url("https://example.com/support")
                                .email("support@example.com"))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .addServersItem(new Server().url("http://localhost:8080").description("Local Development Server with MySQL")) // ambiente de desenvolvimento local
                .addServersItem(new Server().url("https://staging-api.example.com").description("Staging Server for Testing")) // ambiente de homologação, usado para testes antes de ir para produção
                .addServersItem(new Server().url("https://api.example.com/v1").description("Production Server v1"))// servidor de produção
                .addTagsItem(new Tag().name("Clients").description("Operations related to client management"))
                .components(new Components()
                        .addResponses("404", createApiResponse("Resource not found"))
                        .addResponses("500", createApiResponse("Internal Server Error"))
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .security(List.of(new SecurityRequirement().addList("bearerAuth")));  // Aplica segurança global
    }

    private ApiResponse createApiResponse(String description) {
        return new ApiResponse()
                .description(description)
                .content(new Content().addMediaType("application/json",
                        new MediaType().schema(new Schema<>().type("object")
                                .example("{\"error\": \"" + description + "\", \"status\": 404}"))));
    }
}
