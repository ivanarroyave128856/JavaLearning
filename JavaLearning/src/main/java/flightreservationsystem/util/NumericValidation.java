package flightreservationsystem.util;

public class NumericValidation {
    private NumericValidation() {
    }

    public static Boolean isDouble(String number){
        boolean response = true;
        try
        {
            Double.parseDouble(number);
        }
        catch(NumberFormatException e)
        {
            response = false;
        }

        return response;
    }
}
