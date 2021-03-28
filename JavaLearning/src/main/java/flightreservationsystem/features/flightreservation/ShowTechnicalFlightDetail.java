package flightreservationsystem.features.flightreservation;

import com.google.gson.Gson;
import flightreservationsystem.models.TechnicalFlightDetails;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import static flightreservationsystem.constants.Constants.TECHNICAL_FLIGHT_DETAIL_JSON_PATH;
import static flightreservationsystem.util.Util.getBasicFileContent;

public class ShowTechnicalFlightDetail {
    public static void showTechnicalFlightDetail() throws IOException {
        Gson gson = new Gson();
        TechnicalFlightDetails[] technicalFlightDetails = gson.fromJson(
                getBasicFileContent(TECHNICAL_FLIGHT_DETAIL_JSON_PATH),
                TechnicalFlightDetails[].class
        );

        show(technicalFlightDetails);
    }

    private static void show(TechnicalFlightDetails[] technicalFlightDetails){
        StringBuilder print = new StringBuilder();
        for (TechnicalFlightDetails technicalFlightDetail : technicalFlightDetails) {
            print.append("******************");
            print.append("\n");
            print.append("Technical configuration id: ");
            print.append(technicalFlightDetail.getTechnicalConfigurationId());
            print.append("\n");
            print.append("\n");

            print.append("Number of economic seat class: ");
            print.append(technicalFlightDetail.getNumberOfEconomicSeatClass());
            print.append("\n");

            print.append("Price for economic seat class: ");
            print.append(NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                            .format(technicalFlightDetail.getPriceForEconomicSeatClass()));
            print.append("\n");

            print.append("Number of economic seat class for smokers: ");
            print.append(technicalFlightDetail.getNumberOfEconomicSeatClassForSmokers());
            print.append("\n");

            print.append("Economic smoker tax: ");
            print.append(NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                            .format(technicalFlightDetail.getEconomicSmokerTax()));
            print.append("\n");
            print.append("\n");

            print.append("Number of premium seat class: ");
            print.append(technicalFlightDetail.getNumberOfPremiumSeatClass());
            print.append("\n");

            print.append("Price for premium seat class: ");
            print.append(NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                            .format(technicalFlightDetail.getPriceForPremiumSeatClass()));
            print.append("\n");

            print.append("Number of premium seat class for smokers: ");
            print.append(technicalFlightDetail.getNumberOfPremiumSeatClassForSmokers());
            print.append("\n");

            print.append("Premium smoker tax: ");
            print.append(NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                            .format(technicalFlightDetail.getPremiumSmokerTax()));
            print.append("\n");
            print.append("\n");

            print.append("Seats total: ");
            print.append(technicalFlightDetail.getSeatsTotal());
            print.append("\n");
            print.append("******************\n");
        }

        System.out.println(print.toString());
    }
}
