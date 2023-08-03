package com.eldar.invitation.model;

import com.eldar.invitation.enumeration.DocumentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
@Table(name = "person")
@Entity
public class Person {

    @Column(name = "OID")
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    @Column(name = "NAME") @Getter @Setter
    private String name;

    @Column(name = "LASTNAME") @Getter @Setter
    private String lastName;

    @Column(name = "DOCUMENT_TYPE") @Getter @Setter
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(name = "DOCUMENT") @Getter @Setter
    private Integer documentNumber;

    @Column(name = "ADDRESS") @Getter @Setter
    private String address;
}
