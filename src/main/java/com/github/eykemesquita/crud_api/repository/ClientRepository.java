package com.github.eykemesquita.crud_api.repository;

import com.github.eykemesquita.crud_api.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Page<Client> findByNameContainingIgnoreCase(String name, Pageable pageable);

    boolean existsByEmail(String email);

    boolean existsByDocNumber(String docNumber);

    Optional<Client> findByEmail(String email);

}
