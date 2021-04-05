package flightreservationsystem.features;

import com.google.gson.Gson;
import flightreservationsystem.models.FlightStatus;
import java.io.IOException;
import static flightreservationsystem.constants.Constants.CONTROL_FLIGHT_RESERVATION_JSON_PATH;
import static flightreservationsystem.util.Util.getBasicFileContent;

public class Core {
    public static FlightStatus[] getInfoOfFlight() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(
                getBasicFileContent(CONTROL_FLIGHT_RESERVATION_JSON_PATH),
                FlightStatus[].class
        );
    }
}
