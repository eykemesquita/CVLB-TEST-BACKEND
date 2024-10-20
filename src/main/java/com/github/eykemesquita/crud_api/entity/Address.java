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
    private Long id;

    private String createdBy;

    private String modifiedBy;

    private String sapClientId;

    @Enumerated(EnumType.STRING)
    private SapSyncStatus sapSyncStatus;

    private String sapSyncMsg;

    private String addressType;

    private String address;

    private String number;

    private String complement;

    private String city;

    private String state;

    private String zip;

    private String neighborhood;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
