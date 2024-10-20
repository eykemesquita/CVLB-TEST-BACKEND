package com.github.eykemesquita.crud_api.repository;

import com.github.eykemesquita.crud_api.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
