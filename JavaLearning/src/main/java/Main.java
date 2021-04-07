import java.io.IOException;
import java.util.Scanner;
import static flightreservationsystem.features.applicationmanagement.countrymanagement.ShowCountries.showCountries;
import static flightreservationsystem.features.flightreservation.InsertReserve.flightReservation;
import static flightreservationsystem.features.flightreservation.FlightState.flightStatus;
import static flightreservationsystem.features.flightreservation.ShowTechnicalFlightDetail.showTechnicalFlightDetail;
import static flightreservationsystem.features.flightreservation.UpdateReserve.updateReserve;
import static flightreservationsystem.menues.ApplicationManagement.showCountryMenu;
import static flightreservationsystem.menues.ApplicationManagement.showManagerMenu;
import static flightreservationsystem.menues.FlightReservationMenu.showFlightReservation;
import static flightreservationsystem.menues.MainMenu.*;

public class Main {

    public static void main(String[] args) throws IOException {
        mainMenuController();
    }

    private static void mainMenuController() throws IOException {
        Scanner in = new Scanner(System.in);
        short option = 0;

        do {
            showMainMenu();
            option = in.nextShort();

            switch (option){
                case 1:
                    flightReservationController();
                    break;
                case 2:
                    managerMenuController();
                    break;
                case 3:
                    System.out.println("Ha salido de la aplicación.\n\r");
                    break;
                default:
                    System.out.println("Seleccione una opción válida.\n\r");
                    break;
            }

        } while (option != 3);
    }

    private static void  flightReservationController() throws IOException {
        Scanner in = new Scanner(System.in);
        short option = 0;

        do {
            showFlightReservation();
            option = in.nextShort();

            switch (option){
                case 1:
                    showTechnicalFlightDetail();
                    break;
                case 2:
                    flightStatus();
                    break;
                case 3:
                    //flightReservation();
                    break;
                case 4:
                    updateReserve();
                    break;
                case 5:
                    //calcelReserve();
                    break;
                case 6:
                    System.out.println("Ha salido de la reserva de vuelo.\n\r");
                    break;
                default:
                    System.out.println("Seleccione una opción válida.\n\r");
                    break;
            }

        } while (option != 6);
    }

    private static void  managerMenuController() throws IOException {
        Scanner in = new Scanner(System.in);
        short option = 0;

        do {
            showManagerMenu();
            option = in.nextShort();

            switch (option){
                case 1:
                    countryMenuController();
                    break;
                case 2:
                    System.out.println("Ha salido de la administración del aplicativo.\n\r");
                    break;
                default:
                    System.out.println("Seleccione una opción válida.\n\r");
                    break;
            }

        } while (option != 2);
    }

    private static void  countryMenuController() throws IOException {
        Scanner in = new Scanner(System.in);
        short option = 0;

        do {
            showCountryMenu();
            option = in.nextShort();

            switch (option){
                case 1:
                    showCountries();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Ha salido de la administración de países.\n\r");
                    break;
                default:
                    System.out.println("Seleccione una opción válida.\n\r");
                    break;
            }

        } while (option != 5);
    }
}
