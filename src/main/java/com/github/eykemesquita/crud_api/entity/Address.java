package com.github.eykemesquita.crud_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "sap_client_id")
    private String sapClientId;

    @Enumerated(EnumType.STRING)
    @Column(name = "sap_sync_status")
    private SapSyncStatus sapSyncStatus;  // Enum representando o status da sincronização SAP

    @Column(name = "sap_sync_msg")
    private String sapSyncMsg;

    @Column(name = "address_type")
    private String addressType;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "active")
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;  // Relação com a entidade Client

}