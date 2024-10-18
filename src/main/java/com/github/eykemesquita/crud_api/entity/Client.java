package com.github.eykemesquita.crud_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doc_number")
    private String docNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "bith_date")
    private Date birthDate;

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
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "email_opt_in")
    private boolean emailOptIn;

    @Column(name = "sms_opt_in")
    private boolean smsOptIn;

    @Column(name = "whatsapp_opt_in")
    private boolean whatsappOptIn;

    @Column(name = "push_opt_in")
    private boolean pushOptIn;

    //private List<Address> addressList;

}
