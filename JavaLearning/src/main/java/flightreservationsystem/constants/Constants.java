package flightreservationsystem.constants;

public class Constants {
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String JSON_BASE_PATH = USER_DIR + "\\src\\main\\java\\flightreservationsystem\\files\\";
    public static final String CONTROL_FLIGHT_RESERVATION_JSON_PATH = JSON_BASE_PATH + "controlFlightReservation.json";
    public static final String TECHNICAL_FLIGHT_DETAIL_JSON_PATH = JSON_BASE_PATH + "technicalFlightDetail.json";

    public static final String NEW_LINE = "\n";
    public static final String THREE_MIDDLE_LINES_WITH_NEW_LINE = "\t---" + NEW_LINE;

    public static final String SMOKING_SYMBOL = "(~)";
    public static final String ONE_BLANK_SPACE = " ";

}
