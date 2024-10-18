package com.github.eykemesquita.crud_api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long id;

    private String docNumber;

    private String name;

    private String email;

    private String phone;

    private Date birthDate;

    private boolean isEmployee;

    private String stateInscription;

    private String municipalInscription;

    private boolean isBlocked;

    private String createdBy;

    private String modifiedBy;

    private Date createdDate;

    private Date modifiedDate;

    private boolean emailOptIn;

    private boolean smsOptIn;

    private boolean whatsappOptIn;

    private boolean pushOptIn;

    //private List<Address> addressList;

}
