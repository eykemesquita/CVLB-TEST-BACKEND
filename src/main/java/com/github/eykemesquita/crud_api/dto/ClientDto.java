package com.github.eykemesquita.crud_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    @JsonIgnore
    private Long id;

    private String docNumber;

    private String name;

    private String email;

    private String phone;

    private LocalDate birthDate;

    private String stateInscription;

    private String municipalInscription;

    private String createdBy;

    private String modifiedBy;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private boolean emailOptIn;

    private boolean smsOptIn;

    private boolean whatsappOptIn;

    private boolean pushOptIn;

    private boolean employee;

    private boolean blocked;

    private List<AddressDto> addressList;// Mapeia a lista de endereços sem a referência de volta ao cliente
}
