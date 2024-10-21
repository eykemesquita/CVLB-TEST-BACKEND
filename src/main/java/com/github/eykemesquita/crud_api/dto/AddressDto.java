package com.github.eykemesquita.crud_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.eykemesquita.crud_api.entity.SapSyncStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    @JsonIgnore
    private Long id;

    private String createdBy;

    private String modifiedBy;

    private String sapClientId;

    private SapSyncStatus sapSyncStatus;  // Tipo correto para o campo enum

    private String sapSyncMsg;

    private String addressType;

    private String address;

    private String number;

    private String complement;

    private String city;

    private String state;

    private String zip;

    private String neighborhood;

    private boolean active;

    //private ClientDto client; Removida a referência ao ClientDto para evitar ciclo
}
