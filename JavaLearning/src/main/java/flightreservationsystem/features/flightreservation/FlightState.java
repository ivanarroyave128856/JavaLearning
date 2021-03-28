package flightreservationsystem.features.flightreservation;

import com.google.gson.Gson;
import flightreservationsystem.models.FlightStatus;
import flightreservationsystem.models.Seat;
import java.io.IOException;
import static flightreservationsystem.constants.Constants.*;
import static flightreservationsystem.util.Util.getBasicFileContent;

public class FlightState {

    public static void flightStatus() throws IOException {
        Gson gson = new Gson();
        FlightStatus[] flightStatus = gson.fromJson(
                getBasicFileContent(CONTROL_FLIGHT_RESERVATION_JSON_PATH),
                FlightStatus[].class
        );

        show(flightStatus);
    }

    private static void show(FlightStatus[] flightStatus) throws IOException {

        String economicFlightNoBusy = "\t";
        String premiumFlightNoBusy = "\t";

        String economicFlightBusy = "\t";
        String premiumFlightBusy = "\t";

        int numberOfBusySeats = 0;
        int numberOfNoBusySeats = 0;
        int numberOfEconomicFlight = 0;
        int numberOfPremiumFlight = 0;

        Seat seat;

        StringBuilder print = new StringBuilder();
        print.append("****************************" + NEW_LINE);
        print.append("ESTADO DE RESERVAS DE VUELO" + NEW_LINE);
        print.append("****************************" + NEW_LINE);
        print.append(NEW_LINE);

        for (FlightStatus flightState : flightStatus) {

            seat = flightState.getSeat();

            if (seat.isPremium()) {
                numberOfPremiumFlight++;

                if(seat.isBusy()){
                    premiumFlightBusy += (seat.isSmoking()) ? (SMOKING_SYMBOL + seat.getId() + ONE_BLANK_SPACE) : (seat.getId() + ONE_BLANK_SPACE);
                } else {
                    premiumFlightNoBusy += (seat.isSmoking()) ? (SMOKING_SYMBOL + seat.getId() + ONE_BLANK_SPACE) : (seat.getId() + ONE_BLANK_SPACE);
                }

            } else {
                numberOfEconomicFlight++;

                if(seat.isBusy()) {
                    economicFlightBusy += (seat.isSmoking()) ? (SMOKING_SYMBOL + seat.getId() + ONE_BLANK_SPACE) : (seat.getId() + ONE_BLANK_SPACE);
                } else {
                    economicFlightNoBusy += (seat.isSmoking()) ? (SMOKING_SYMBOL + seat.getId() + ONE_BLANK_SPACE) : (seat.getId() + ONE_BLANK_SPACE);
                }
            }

            if (seat.isBusy()) {
                numberOfBusySeats++;
            } else {
                numberOfNoBusySeats++;
            }

        }

        print.append(">>>>Detalle general<<<<" + NEW_LINE);
        print.append("Número de sillas: " + (numberOfEconomicFlight + numberOfPremiumFlight) + NEW_LINE);
        print.append("Económicas: " + numberOfEconomicFlight + NEW_LINE);
        print.append("Premium: " + numberOfPremiumFlight + NEW_LINE);
        print.append(NEW_LINE);

        print.append(">>>>Detalle de reservas<<<<" + NEW_LINE);
        print.append(NEW_LINE);
        print.append(">>Convenciones<<");
        print.append(NEW_LINE);
        print.append(SMOKING_SYMBOL + " ==> Fumador.");
        print.append(NEW_LINE);
        print.append(NEW_LINE);

        print.append("Reservadas: " + numberOfBusySeats + NEW_LINE);
        print.append("Económicas" + NEW_LINE);
        print.append(economicFlightBusy.trim().isEmpty() ? THREE_MIDDLE_LINES_WITH_NEW_LINE : economicFlightBusy + NEW_LINE);
        print.append("Premium" + NEW_LINE);
        print.append(premiumFlightBusy.trim().isEmpty() ? THREE_MIDDLE_LINES_WITH_NEW_LINE : premiumFlightBusy + NEW_LINE);
        print.append(NEW_LINE);

        print.append("Por reservar: " + numberOfNoBusySeats + NEW_LINE);
        print.append("Econ?micas:" + NEW_LINE);
        print.append(economicFlightNoBusy.trim().isEmpty() ? THREE_MIDDLE_LINES_WITH_NEW_LINE : economicFlightNoBusy + NEW_LINE);
        print.append("Premium:" + NEW_LINE);
        print.append(premiumFlightNoBusy.trim().isEmpty() ? THREE_MIDDLE_LINES_WITH_NEW_LINE : premiumFlightNoBusy + NEW_LINE);
        print.append(NEW_LINE);

        print.append("******************" + NEW_LINE);
        System.out.println(print.toString());
    }
}
