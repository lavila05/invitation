package com.eldar.invitation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class PersonRequestDTO {

    @Setter
    private String oid;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String documentType;
    @Getter @Setter
    private String documentNumber;
}
