package com.github.eykemesquita.crud_api.mapper;

import com.github.eykemesquita.crud_api.dto.ClientDto;
import com.github.eykemesquita.crud_api.entity.Client;

public class ClientMapper {

    public static ClientDto mapToClientDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getDocNumber(),
                client.getName(),
                client.getEmail(),
                client.getPhone(),
                client.getBirthDate(),
                client.isEmployee(),
                client.getStateInscription(),
                client.getMunicipalInscription(),
                client.isBlocked(),
                client.getCreatedBy(),
                client.getModifiedBy(),
                client.getCreatedDate(),
                client.getModifiedDate(),
                client.isEmailOptIn(),
                client.isSmsOptIn(),
                client.isWhatsappOptIn(),
                client.isPushOptIn()
        );
    }

    public static Client mapToClient(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getDocNumber(),
                clientDto.getName(),
                clientDto.getEmail(),
                clientDto.getPhone(),
                clientDto.getBirthDate(),
                clientDto.isEmployee(),
                clientDto.getStateInscription(),
                clientDto.getMunicipalInscription(),
                clientDto.isBlocked(),
                clientDto.getCreatedBy(),
                clientDto.getModifiedBy(),
                clientDto.getCreatedDate(),
                clientDto.getModifiedDate(),
                clientDto.isEmailOptIn(),
                clientDto.isSmsOptIn(),
                clientDto.isWhatsappOptIn(),
                clientDto.isPushOptIn()
        );
    }

}
