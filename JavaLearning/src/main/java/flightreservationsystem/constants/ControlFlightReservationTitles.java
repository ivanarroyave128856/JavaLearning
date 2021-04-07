package flightreservationsystem.constants;

public enum ControlFlightReservationTitles {
    AIRPORT("Aeropuerto"),
    COUNTRY("País"),
    CITY("Ciudad"),
    ADDRESS("Dirección"),
    FROM_COUNTRY("Desde el país"),
    TO_COUNTRY("Hacia el país"),
    FROM_CITY("Desde la ciudad"),
    TO_CITY("Hacia la ciudad"),
    IS_LOCAL("¿Vuelo local?"),
    FLIGHT_DATE("Fecha de vuelo dd/MM/yyyy"),
    FLIGHT_TIME("Hora de vuelo"),
    PERSON_ID("Identificación"),
    PERSON_ID_TYPE("Tipo de identificación"),
    FIRST_NAME("Primer nombre"),
    SECOND_NAME("Segundo nombre"),
    FIRST_SURNAME("Primer apellido"),
    SECOND_SURNAME("Segundo apellido"),
    AGE("Edad"),
    SEX("Sexo"),
    WEIGHT("Peso"),
    PHONE_NUMBER("Teléfono"),
    SEAT_ID("Silla"),
    IS_SMOKING("¿Es para fumador?"),
    IS_PREMIUM("¿Es premium?"),
    IS_BUSY("¿Está ocupada?"),
    TECHNICAL_CONFIGURATION_ID("Identificación de vuelo"),
    NUMBER_OF_ECONOMIC_SEATS("Número de sillas económicas"),
    PRICE_FOR_ECONOMIC_SEATS("Precio para silla económica"),
    NUMBER_OF_ECONOMIC_SEAT_FOR_SMOKERS("Número de sillas económicas para fumadores"),
    ECONOMIC_SMOKER_TAX("Impuesto para sillas económicas de fumadores"),
    NUMBER_OF_PREMIUM_SEATS("Número de sillas premium"),
    PRICE_FOR_PREMIUM_SEATS("Precio para silla premium"),
    NUMBER_OF_PREMIUM_SEAT_FOR_SMOKERS("Número de sillas premium para fumadores"),
    PREMIUM_SMOKER_TAX("Impuesto para sillas premium de fumadores"),
    TOTAL_SEATS("Total de sillas"),
    INSERT("Insert"),
    CANCEL("Cancel"),
    UPDATE("Update");

    private final String value;

    public String getValue() {
        return value;
    }

    ControlFlightReservationTitles(String value) {
        this.value = value;
    }
}
