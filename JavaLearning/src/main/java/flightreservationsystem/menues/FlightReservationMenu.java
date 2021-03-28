package flightreservationsystem.menues;

public class FlightReservationMenu {
    public static void showFlightReservation(){
        StringBuilder menu = new StringBuilder();
        menu.append("====================\n");
        menu.append("RESERVA DE VUELOS.\n");
        menu.append("====================\n");
        menu.append("1. Detalle t?cnico de vuelo.\n");
        menu.append("2. Estado actual de vuelo.\n");
        menu.append("3. Reservar asiento.\n");
        menu.append("4. Modificar reserva de asiento.\n");
        menu.append("5. Eliminar reserva de asiento.\n");
        menu.append("6. Regresar.\n");
        menu.append("====================\n");
        menu.append("\r\n");

        System.out.println(menu.toString());
    }
}
