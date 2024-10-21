package com.github.eykemesquita.crud_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "doc_number", nullable = false, unique = true)
    private String docNumber;  // Documento único do cliente

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "is_employee")
    private boolean isEmployee;

    @Column(name = "state_inscription")
    private String stateInscription;

    @Column(name = "municipal_inscription")
    private String municipalInscription;

    @Column(name = "is_blocked")
    private boolean isBlocked;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "email_opt_in")
    private boolean emailOptIn;

    @Column(name = "sms_opt_in")
    private boolean smsOptIn;

    @Column(name = "whatsapp_opt_in")
    private boolean whatsappOptIn;

    @Column(name = "push_opt_in")
    private boolean pushOptIn;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();  // Relação com Address
}