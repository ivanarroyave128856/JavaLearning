package flightreservationsystem.enums;

public enum IdentificationType {
    CEDULA_DE_CIUDADANIA("Cédula de ciudadania"),
    CEDULA_DE_EXTRANJERIA("Cédula de extranjería"),
    REGISTRO_CIVIL("Registro civil"),
    TARJETA_DE_IDENTIDAD("Tarjeta de identidad");

    private String value;

    public String getValue() {
        return value;
    }

    private IdentificationType(String female) {
    }
}
