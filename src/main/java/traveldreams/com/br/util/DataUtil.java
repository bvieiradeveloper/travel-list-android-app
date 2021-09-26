package traveldreams.com.br.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DD_MM = "dd/MM";
    public static final String AT = " at ";

    public static String DateRoundInString(int days)
    {
        Calendar departureDate  = Calendar.getInstance();
        Calendar returnDate  = Calendar.getInstance();
        returnDate.add(returnDate.DATE, days);

        SimpleDateFormat dateFormat = new SimpleDateFormat(DD_MM);

        String RoundTrip = dateFormat.format(departureDate.getTime()) + " - " + dateFormat.format(returnDate.getTime()) + AT + returnDate.get(Calendar.YEAR);

        return RoundTrip;
    }
}
