package methods;

import java.text.DecimalFormat;

public class Methods {
    public static String formatNumber(String number) {
        double parsedNumber = Double.parseDouble(number);
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(parsedNumber);
    }
}
