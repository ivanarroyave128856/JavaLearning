package flightreservationsystem.features.flightreservation;

import com.google.gson.Gson;
import flightreservationsystem.models.FlightStatus;
import flightreservationsystem.models.Person;
import flightreservationsystem.models.Seat;
import java.io.IOException;
import static flightreservationsystem.constants.Constants.*;
import static flightreservationsystem.features.Core.getInfoOfFlight;
import static flightreservationsystem.features.Core.saveChanges;
import static flightreservationsystem.util.Util.getBasicFileContent;

public class InsertReserve {

    public static boolean flightReservation(Object[] selectedRow) throws IOException {

        Seat seat = getInfoOfSeatFromScreen(selectedRow);
        Person person = getInfoOfPersonFromScreen(selectedRow);
        FlightStatus[] flightStatus = getInfoOfFlight();

        saveChanges(withFollowingInformation(flightStatus, seat, person));

        return verifyReservation(flightStatus);
    }

    private static Seat getInfoOfSeatFromScreen(Object[] selectedRow){
        Seat seat = new Seat();
        seat.setId(selectedRow[0].toString());
        seat.setBusy(true);

        return seat;
    }

    private static Person getInfoOfPersonFromScreen(Object[] selectedRow){
        Person person = new Person();
        person.setFirstName(selectedRow[4].toString());
        person.setSecondName(selectedRow[5].toString());
        person.setFirstSurname(selectedRow[6].toString());
        person.setSecondSurname(selectedRow[7].toString());
        person.setIdentificationType(selectedRow[8].toString());
        person.setIdentification(selectedRow[9].toString());
        person.setAge(Short.parseShort(selectedRow[10].toString()));
        person.setSex(selectedRow[11].toString());
        person.setWeight(Double.parseDouble(selectedRow[12].toString()));
        person.setPhoneNumber(selectedRow[13].toString());

        return person;
    }

    private static FlightStatus[] withFollowingInformation(FlightStatus[] flightStatus, Seat seat, Person person){
        for (FlightStatus flightState : flightStatus) {
            if(flightState.getSeat().getId().equalsIgnoreCase(seat.getId())) {
                //Seat information.
                flightState.getSeat().setBusy(seat.isBusy());
                //Customer information..
                flightState.getPerson().setIdentification(person.getIdentification());
                flightState.getPerson().setIdentificationType(person.getIdentificationType());
                flightState.getPerson().setFirstName(person.getFirstName());
                flightState.getPerson().setSecondName(person.getSecondName());
                flightState.getPerson().setFirstSurname(person.getFirstSurname());
                flightState.getPerson().setSecondSurname(person.getSecondSurname());
                flightState.getPerson().setAge(person.getAge());
                flightState.getPerson().setSex(person.getSex());
                flightState.getPerson().setWeight(person.getWeight());
                flightState.getPerson().setPhoneNumber(person.getPhoneNumber());
                break;
            }
        }
        return flightStatus;
    }

    private static boolean verifyReservation(FlightStatus[] flightStatus) throws IOException {
        Gson gson = new Gson();
        FlightStatus[] flgStatus = gson.fromJson(
                getBasicFileContent(CONTROL_FLIGHT_RESERVATION_JSON_PATH),
                FlightStatus[].class
        );

        for (FlightStatus flightState : flightStatus)
            for (FlightStatus flgState : flgStatus)
                if((flightState.getSeat().getId().equalsIgnoreCase(flgState.getSeat().getId()))
                                && (flightState.getSeat().isBusy() == flgState.getSeat().isBusy()))
                    return true;

        return false;
    }

}
