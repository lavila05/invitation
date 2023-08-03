package com.eldar.invitation.dto;

import lombok.Getter;
import lombok.Setter;

public class PersonResponseDTO {

    @Getter @Setter
    private Long oid;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String documentType;
    @Getter @Setter
    private String documentNumber;
}
