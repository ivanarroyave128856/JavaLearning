package flightreservationsystem.menues;

public class ApplicationManagement {
    public static void showManagerMenu(){
        StringBuilder menu = new StringBuilder();
        menu.append("====================\n");
        menu.append("ADMINISTRACI?N DE APLICACI?N.\n");
        menu.append("====================\n");
        menu.append("1. Administraci?n de pa?ses.\n");
        menu.append("2. Regresar.\n");
        menu.append("====================\n");
        menu.append("\r\n");

        System.out.println(menu.toString());
    }
    public static void showCountryMenu(){
        StringBuilder menu = new StringBuilder();
        menu.append("====================\n");
        menu.append("ADMINISTRACI?N DE PA?SES.\n");
        menu.append("====================\n");
        menu.append("1. Mostrar pa?ses.\n");
        menu.append("2. Ingresar pa?s.\n");
        menu.append("3. Actualizar pa?s.\n");
        menu.append("4. Eliminar pa?s.\n");
        menu.append("5. Regresar.\n");
        menu.append("====================\n");
        menu.append("\r\n");

        System.out.println(menu.toString());
    }
}
