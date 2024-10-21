package com.github.eykemesquita.crud_api.repository;

import com.github.eykemesquita.crud_api.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    // Encontra todos os endereços associados ao ID de um cliente específico
    List<Address> findByClientId(Long clientId);
}
