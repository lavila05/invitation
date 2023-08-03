package com.eldar.invitation.enumeration;

public enum DocumentType {

    DNI("DNI"), CUIT("CUIT");

    private final String value;

    public static DocumentType getEnum(String value) {
        for (DocumentType v : values())
            if (v.getValue().equalsIgnoreCase(value))
                return v;
        throw new IllegalArgumentException();
    }

    DocumentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
