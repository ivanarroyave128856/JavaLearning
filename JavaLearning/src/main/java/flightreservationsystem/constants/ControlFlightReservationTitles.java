package flightreservationsystem.constants;

public enum ControlFlightReservationTitles {
    AIRPORT("Aeropuerto"),
    COUNTRY("Pa�s"),
    CITY("Ciudad"),
    ADDRESS("Direcci�n"),
    FROM_COUNTRY("Desde el pa�s"),
    TO_COUNTRY("Hacia el pa�s"),
    FROM_CITY("Desde la ciudad"),
    TO_CITY("Hacia la ciudad"),
    IS_LOCAL("�Vuelo local?"),
    FLIGHT_DATE("Fecha de vuelo dd/MM/yyyy"),
    FLIGHT_TIME("Hora de vuelo"),
    PERSON_ID("Identificaci�n"),
    PERSON_ID_TYPE("Tipo de identificaci�n"),
    FIRST_NAME("Primer nombre"),
    SECOND_NAME("Segundo nombre"),
    FIRST_SURNAME("Primer apellido"),
    SECOND_SURNAME("Segundo apellido"),
    AGE("Edad"),
    SEX("Sexo"),
    WEIGHT("Peso"),
    PHONE_NUMBER("Tel�fono"),
    SEAT_ID("Silla"),
    IS_SMOKING("�Es para fumador?"),
    IS_PREMIUM("�Es premium?"),
    IS_BUSY("�Est� ocupada?"),
    TECHNICAL_CONFIGURATION_ID("Identificaci�n de vuelo"),
    NUMBER_OF_ECONOMIC_SEATS("N�mero de sillas econ�micas"),
    PRICE_FOR_ECONOMIC_SEATS("Precio para silla econ�mica"),
    NUMBER_OF_ECONOMIC_SEAT_FOR_SMOKERS("N�mero de sillas econ�micas para fumadores"),
    ECONOMIC_SMOKER_TAX("Impuesto para sillas econ�micas de fumadores"),
    NUMBER_OF_PREMIUM_SEATS("N�mero de sillas premium"),
    PRICE_FOR_PREMIUM_SEATS("Precio para silla premium"),
    NUMBER_OF_PREMIUM_SEAT_FOR_SMOKERS("N�mero de sillas premium para fumadores"),
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
