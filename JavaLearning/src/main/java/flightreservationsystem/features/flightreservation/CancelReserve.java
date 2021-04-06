package flightreservationsystem.features.flightreservation;

import flightreservationsystem.models.FlightStatus;
import java.io.IOException;
import static flightreservationsystem.features.Core.getInfoOfFlight;
import static flightreservationsystem.features.Core.saveChanges;
import static jdk.internal.joptsimple.internal.Strings.EMPTY;

public class CancelReserve {
    public static void calcelReservation(String seatId) throws IOException {
        saveChanges(withCancelationObjectDefined(seatId));
    }

    private static FlightStatus[] withCancelationObjectDefined(String seatId) throws IOException {
        //Flight list from JSON file.
        FlightStatus[] inJSonFile = getInfoOfFlight();

        for (FlightStatus row : inJSonFile) {
            if(row.getSeat().getId().equalsIgnoreCase(seatId)){
                row.getSeat().setBusy(false);
                row.getPerson().setFirstName(EMPTY);
                row.getPerson().setSecondName(EMPTY);
                row.getPerson().setFirstSurname(EMPTY);
                row.getPerson().setSecondSurname(EMPTY);
                row.getPerson().setIdentificationType(EMPTY);
                row.getPerson().setIdentification(EMPTY);
                row.getPerson().setAge((short) 0);
                row.getPerson().setSex(EMPTY);
                row.getPerson().setWeight(0d);
                row.getPerson().setPhoneNumber(EMPTY);
            }
        }

        return inJSonFile;
    }
}
