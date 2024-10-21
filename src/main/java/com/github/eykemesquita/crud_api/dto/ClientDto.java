package com.github.eykemesquita.crud_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Objeto de transferência de dados que representa um cliente")
public class ClientDto {

    @JsonIgnore
    @Schema(description = "Identificador único do cliente", example = "1")
    private Long id;

    @Schema(description = "Documento de identificação do cliente", example = "12345678901")
    private String docNumber;

    @Schema(description = "Nome completo do cliente", example = "John Doe")
    private String name;

    @Schema(description = "Endereço de e-mail do cliente", example = "johndoe@example.com")
    private String email;

    @Schema(description = "Número de telefone do cliente", example = "555-1234")
    private String phone;

    @Schema(description = "Data de nascimento do cliente", example = "1990-01-01")
    private LocalDate birthDate;

    @Schema(description = "Inscrição estadual do cliente", example = "RJ")
    private String stateInscription;

    @Schema(description = "Inscrição municipal do cliente", example = "Bridge")
    private String municipalInscription;

    @Schema(description = "Usuário que criou o registro do cliente", example = "Admin")
    private String createdBy;

    @Schema(description = "Usuário que modificou o registro do cliente", example = "Admin")
    private String modifiedBy;

    @Schema(description = "Data de criação do registro", example = "2024-01-01T10:15:30")
    private LocalDateTime createdDate;

    @Schema(description = "Data da última modificação", example = "2024-01-05T11:45:30")
    private LocalDateTime modifiedDate;

    @Schema(description = "Indica se o cliente optou por receber e-mails", example = "true")
    private boolean emailOptIn;

    @Schema(description = "Indica se o cliente optou por receber SMS", example = "false")
    private boolean smsOptIn;

    @Schema(description = "Indica se o cliente optou por receber mensagens via WhatsApp", example = "true")
    private boolean whatsappOptIn;

    @Schema(description = "Indica se o cliente optou por notificações push", example = "false")
    private boolean pushOptIn;

    @Schema(description = "Indica se o cliente é funcionário", example = "false")
    private boolean employee;

    @Schema(description = "Indica se o cliente está bloqueado", example = "false")
    private boolean blocked;

    @Schema(description = "Lista de endereços associados ao cliente")
    private List<AddressDto> addressList = new ArrayList<>();
}