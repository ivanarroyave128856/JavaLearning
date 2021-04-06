package flightreservationsystem.features.flightreservation;

import com.google.gson.Gson;
import flightreservationsystem.models.FlightStatus;
import flightreservationsystem.models.Person;
import flightreservationsystem.models.Seat;
import flightreservationsystem.models.TechnicalFlightDetails;
import java.io.IOException;
import java.util.Scanner;
import static flightreservationsystem.constants.Constants.*;
import static flightreservationsystem.features.Core.saveChanges;
import static flightreservationsystem.features.flightreservation.FlightState.flightStatus;
import static flightreservationsystem.util.Util.getBasicFileContent;
import static flightreservationsystem.util.Util.saveFile;

public class InsertReserve {

    public static void flightReservation() throws IOException {

        if(numberOfReservations() >= numberOfAllowedReservations()) {
            System.out.println("*****EL VUELO ESTÁ COMPLETO*****" + NEW_LINE);
            return;
        }
        else
            flightStatus();

        System.out.println("****POR FAVOR INGRESE LA INFORMACIÓN SOLICITADA****" + NEW_LINE);

        Seat seat = getInfoOfSeatFromScreen();
        Person person = getInfoOfPersonFromScreen();
        FlightStatus[] flightStatus = getInfoOfFlight();

        saveChanges(withFollowingInformation(flightStatus, seat, person));

        if(verifyReservation(flightStatus))
            System.out.println("*****Vuelo Reservado*****");
        else
            System.out.println("*****Hubo un problema al reservar el vuelo. Contacte al administrador*****");

    }

    private static Seat getInfoOfSeatFromScreen(){
        Seat seat = new Seat();
        Scanner in = new Scanner(System.in);

        System.out.println("Identificador de la silla:");
        seat.setId(in.next().trim());

        seat.setBusy(true);

        return seat;
    }

    private static Person getInfoOfPersonFromScreen(){
        Person person = new Person();
        Scanner in = new Scanner(System.in);

        System.out.println("Tipo de identificaci?n del cliente:");
        System.out.println("RCN para Registro de Civil de Nacimiento");
        System.out.println("TI para Tarjeta de Identidad");
        System.out.println("CC para C?dula de Ciudadan?a");
        System.out.println("CE para C?dula de Extranjer?a");
        System.out.println("PAS para Pasaporte");
        person.setIdentificationType(in.next().trim());

        System.out.println("N?mero de identificaci?n del cliente:");
        person.setIdentification(in.next().trim());

        System.out.println("Primer nombre del cliente:");
        person.setFirstName(in.next().trim());

        System.out.println("Segundo nombre del cliente:");
        person.setSecondName(in.next().trim());

        System.out.println("Primer apellido del cliente:");
        person.setFirstSurname(in.next().trim());

        System.out.println("Segundo apellido del cliente:");
        person.setSecondSurname(in.next().trim());

        System.out.println("Edad del cliente:");
        person.setAge(in.nextShort());

        System.out.println("Sexo del cliente:");
        System.out.println("M para Masculino");
        System.out.println("F para Femenino");
        person.setSex(in.next().trim());

        System.out.println("Peso del cliente en kilogramos en formato ##,##:");
        person.setWeight(in.nextDouble());

        System.out.println("N?mero de m?vil del cliente en formato +[indicativo de pa?s] [N?mero de m?vil]:");
        person.setPhoneNumber(in.next().trim());

        return person;
    }

    private static FlightStatus[] getInfoOfFlight() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(
                getBasicFileContent(CONTROL_FLIGHT_RESERVATION_JSON_PATH),
                FlightStatus[].class
        );
    }

    private static FlightStatus[] withFollowingInformation(FlightStatus[] flightStatus, Seat seat, Person person){
        for (FlightStatus flightState : flightStatus) {
            if(flightState.getSeat().getId().equalsIgnoreCase(seat.getId())) {

                //Informaci?n de silla.
                flightState.getSeat().setBusy(seat.isBusy());

                //Informaci?n de cliente.
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

    private static int numberOfReservations() throws IOException {
        int reservations = 0;
        Gson gson = new Gson();
        FlightStatus[] flightStatus = gson.fromJson(
                getBasicFileContent(CONTROL_FLIGHT_RESERVATION_JSON_PATH),
                FlightStatus[].class
        );

        for (FlightStatus flightState : flightStatus)
            if(flightState.getSeat().isBusy())
                reservations++;

        return reservations;
    }

    private static int numberOfAllowedReservations() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(
                getBasicFileContent(TECHNICAL_FLIGHT_DETAIL_JSON_PATH),
                TechnicalFlightDetails[].class
        )[0].getSeatsTotal();
    }

}
