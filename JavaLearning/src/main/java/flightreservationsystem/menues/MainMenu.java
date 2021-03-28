package flightreservationsystem.menues;

public class MainMenu {
    public static void showMainMenu(){
        StringBuilder menu = new StringBuilder();
        menu.append("====================\n");
        menu.append("MENÚ PRINCIPAL.\n");
        menu.append("====================\n");
        menu.append("1. Reserva de vuelos.\n");
        menu.append("2. Administración de aplicación.\n");
        menu.append("3. Salir.\n");
        menu.append("====================\n");
        menu.append("\r\n");

        System.out.println(menu.toString());
    }
}
