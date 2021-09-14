package traveldreams.com.br.util;

public class DayUtil {

    public static final String FIRST_DAY = " day";
    public static final String OTHER_DAYS = " days";

    public final static String dayFormat(int day)
    {
        String formattedDay = day == 1 ? day + FIRST_DAY : day + OTHER_DAYS;
        return formattedDay;
    }
}
