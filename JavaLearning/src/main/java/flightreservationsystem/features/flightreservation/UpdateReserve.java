package flightreservationsystem.features.flightreservation;

import com.google.gson.Gson;
import flightreservationsystem.models.FlightStatus;

import java.io.IOException;
import java.util.Scanner;

import static flightreservationsystem.constants.Constants.CONTROL_FLIGHT_RESERVATION_JSON_PATH;
import static flightreservationsystem.constants.Constants.NEW_LINE;
import static flightreservationsystem.features.flightreservation.FlightState.flightStatus;
import static flightreservationsystem.util.Util.getBasicFileContent;

public class UpdateReserve {
    public static void updateReserve() throws IOException {
        flightStatus();

        System.out.println("****POR FAVOR INGRESE LA INFORMACIÓN SOLICITADA****" + NEW_LINE + NEW_LINE);

        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el identificador de silla:");
        String seatId = in.next();

        System.out.println("Ingrese el tipo de documento del cliente:");
        String identificationType  = in.next();

        System.out.println("Ingrese el número de documento del cliente:");
        String identification  = in.next();

        System.out.println(NEW_LINE + NEW_LINE);

        FlightStatus flightStatus = getInfoOfOneFlight(getInfoOfFlight(), seatId, identificationType, identification);

        if(flightStatus == null) {
            System.out.println("No hay sillas asociadas" + NEW_LINE);
            return;
        }

        showReservationStatus(flightStatus);


    }

    private static FlightStatus[] getInfoOfFlight() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(
                getBasicFileContent(CONTROL_FLIGHT_RESERVATION_JSON_PATH),
                FlightStatus[].class
        );
    }

    private static FlightStatus getInfoOfOneFlight(FlightStatus[] flightStatus,
                                                   String seatId, String identificationType,
                                                   String identification) throws IOException {

        for (FlightStatus flightState : flightStatus)
            if(flightState.getSeat().getId().equalsIgnoreCase(seatId) &&
                    flightState.getPerson().getIdentificationType().equalsIgnoreCase(identificationType) &&
                    flightState.getPerson().getIdentification().equalsIgnoreCase(identification))
                return flightState;

        return null;
    }

    private static void showReservationStatus(FlightStatus flightStatus){
        System.out.println("****Resultado de búsqueda****" + NEW_LINE + NEW_LINE);
        flightStatus.getSeat().getId();


    }

}
