package flightreservationsystem.features.applicationmanagement.countrymanagement;

import com.google.gson.Gson;
import flightreservationsystem.models.Country;
import java.io.IOException;
import static flightreservationsystem.constants.Constants.JSON_BASE_PATH;
import static flightreservationsystem.util.Util.getBasicFileContent;

public class ShowCountries {

    public static void showCountries() throws IOException {
        Gson gson = new Gson();
        Country[] countries = gson.fromJson(
                getBasicFileContent(JSON_BASE_PATH + "country.json"),
                Country[].class
        );

        show(countries);
    }

    private static void show(Country[] countries){
        System.out.println("Identificador - Nombre\r");
        for (Country country : countries) {
            System.out.println(country.getId() + " - " + country.getName());
        }
        System.out.println("******************\n");
    }
}
