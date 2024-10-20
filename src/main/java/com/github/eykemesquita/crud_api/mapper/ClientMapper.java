package com.github.eykemesquita.crud_api.mapper;

import com.github.eykemesquita.crud_api.dto.AddressDto;
import com.github.eykemesquita.crud_api.dto.ClientDto;
import com.github.eykemesquita.crud_api.entity.Address;
import com.github.eykemesquita.crud_api.entity.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {

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
                client.isPushOptIn(),
                addressList
        );
    }

    public static Client mapToClient(ClientDto clientDto) {
        // Certifique-se de que a variável 'addressList' é declarada corretamente
        List<Address> addressList = clientDto.getAddressList().stream()
                .map(AddressMapper::mapToAddress)
                .collect(Collectors.toList());

        // Certifique-se de que a variável 'client' é declarada corretamente com o construtor adequado
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
                addressList  // Passando a lista de endereços como último argumento
        );

        // Agora, o 'client' está corretamente inicializado, e você pode associar a lista de endereços
        client.setAddresses(addressList);  // Associando a lista de Address ao Client

        return client;
    }

}

