package traveldreams.com.br.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CoinUtil {

    public static final String CURRENT_COIN_TARGET = "R$";
    public static final String CURRENT_COIN_FORMATTED = "R$ ";
    public static final String PORTUGUES = "pt";
    public static final String BRAZIL = "br";

    public static final String coinFormat(BigDecimal coinValue)
    {
        NumberFormat currencyCoinFormat = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRAZIL));
        String formattedPrice = currencyCoinFormat.format(coinValue).replace(CURRENT_COIN_TARGET, CURRENT_COIN_FORMATTED);
        return formattedPrice;
    }
}
