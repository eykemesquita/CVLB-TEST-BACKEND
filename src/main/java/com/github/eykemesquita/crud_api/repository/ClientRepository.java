package com.github.eykemesquita.crud_api.repository;

import com.github.eykemesquita.crud_api.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
