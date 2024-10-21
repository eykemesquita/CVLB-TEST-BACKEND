package com.github.eykemesquita.crud_api.mapper;

import com.github.eykemesquita.crud_api.dto.AddressDto;
import com.github.eykemesquita.crud_api.dto.ClientDto;
import com.github.eykemesquita.crud_api.entity.Address;
import com.github.eykemesquita.crud_api.entity.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {

    // Converte a entidade Client para ClientDto
    public static ClientDto mapToClientDto(Client client) {
        List<AddressDto> addressList = client.getAddresses().stream()
                .map(AddressMapper::mapToAddressDto)
                .collect(Collectors.toList());

        return new ClientDto(
                client.getId(),
                client.getDocNumber(),
                client.getName(),
                client.getEmail(),
                client.getPhone(),
                client.getBirthDate(),
                client.getStateInscription(),
                client.getMunicipalInscription(),
                client.getCreatedBy(),
                client.getModifiedBy(),
                client.getCreatedDate(),
                client.getModifiedDate(),
                client.isEmailOptIn(),
                client.isSmsOptIn(),
                client.isWhatsappOptIn(),
                client.isPushOptIn(),
                client.isEmployee(),
                client.isBlocked(),
                addressList // Lista de endereços associada
        );
    }

    // Converte ClientDto para a entidade Client
    public static Client mapToClient(ClientDto clientDto) {
        List<Address> addressList = clientDto.getAddressList().stream()
                .map(AddressMapper::mapToAddress)
                .collect(Collectors.toList());

        Client client = new Client(
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
                clientDto.isPushOptIn(),
                addressList // Lista de endereços associada
        );

        client.setAddresses(addressList);  // Associa a lista de endereços ao cliente

        return client;
    }
}
