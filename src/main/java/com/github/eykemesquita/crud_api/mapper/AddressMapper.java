package com.github.eykemesquita.crud_api.mapper;

import com.github.eykemesquita.crud_api.dto.AddressDto;
import com.github.eykemesquita.crud_api.entity.Address;

public class AddressMapper {

    // Converte a entidade Address para AddressDto
    public static AddressDto mapToAddressDto(Address address) {
        return new AddressDto(
                address.getId(),
                address.getCreatedBy(),
                address.getModifiedBy(),
                address.getSapClientId(),
                address.getSapSyncStatus(),
                address.getSapSyncMsg(),
                address.getAddressType(),
                address.getAddress(),
                address.getNumber(),
                address.getComplement(),
                address.getCity(),
                address.getState(),
                address.getZip(),
                address.getNeighborhood(),
                address.isActive()
        );
    }

    // Converte AddressDto para a entidade Address
    public static Address mapToAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setCreatedBy(addressDto.getCreatedBy());
        address.setModifiedBy(addressDto.getModifiedBy());
        address.setSapClientId(addressDto.getSapClientId());
        address.setSapSyncStatus(addressDto.getSapSyncStatus());
        address.setSapSyncMsg(addressDto.getSapSyncMsg());
        address.setAddressType(addressDto.getAddressType());
        address.setAddress(addressDto.getAddress());
        address.setNumber(addressDto.getNumber());
        address.setComplement(addressDto.getComplement());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setZip(addressDto.getZip());
        address.setNeighborhood(addressDto.getNeighborhood());
        address.setActive(addressDto.isActive());

        return address;
    }
}
