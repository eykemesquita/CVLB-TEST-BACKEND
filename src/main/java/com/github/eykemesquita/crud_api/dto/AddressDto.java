package com.github.eykemesquita.crud_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.eykemesquita.crud_api.entity.SapSyncStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Objeto de transferência de dados que representa um endereço")
public class AddressDto {

    @JsonIgnore
    @Schema(description = "Identificador único do endereço", example = "1")
    private Long id;

    @Schema(description = "Usuário que criou o endereço", example = "Admin")
    private String createdBy;

    @Schema(description = "Usuário que modificou o endereço", example = "Admin")
    private String modifiedBy;

    @Schema(description = "ID do cliente SAP associado", example = "SAP123456")
    private String sapClientId;

    @Schema(description = "Status de sincronização com o SAP", example = "SYNCED")
    private SapSyncStatus sapSyncStatus; // Enum representando o status de sincronização

    @Schema(description = "Mensagem de sincronização do SAP", example = "Sincronizado com sucesso")
    private String sapSyncMsg;

    @Schema(description = "Tipo do endereço", example = "Comercial")
    private String addressType;

    @Schema(description = "Endereço completo", example = "Rua 1")
    private String address;

    @Schema(description = "Número do endereço", example = "123")
    private String number;

    @Schema(description = "Complemento do endereço", example = "Apto 101")
    private String complement;

    @Schema(description = "Cidade", example = "São Paulo")
    private String city;

    @Schema(description = "Estado", example = "SP")
    private String state;

    @Schema(description = "CEP", example = "01000-000")
    private String zip;

    @Schema(description = "Bairro", example = "Centro")
    private String neighborhood;

    @Schema(description = "Se o endereço está ativo", example = "true")
    private boolean active;

    // A referência ao cliente foi removida para evitar ciclos e manter a simplicidade do DTO
}