package com.github.eykemesquita.crud_api.repository;

import com.github.eykemesquita.crud_api.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    // Busca paginada de clientes cujo nome contenha o valor fornecido (ignorando maiúsculas/minúsculas)
    Page<Client> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Verifica se já existe um cliente com o email fornecido
    boolean existsByEmail(String email);

    // Verifica se já existe um cliente com o documento fornecido
    boolean existsByDocNumber(String docNumber);

    // Busca cliente pelo email
    Optional<Client> findByEmail(String email);
}
