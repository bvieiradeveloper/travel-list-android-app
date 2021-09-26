package traveldreams.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import traveldreams.com.br.R;
import traveldreams.com.br.model.Package;
import traveldreams.com.br.util.CoinUtil;
import traveldreams.com.br.util.DataUtil;
import traveldreams.com.br.util.DayUtil;
import traveldreams.com.br.util.ResourceUtil;

public class ResumePackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_package);

        setTitle("Package Resume");

        final Package aPackage = new Package("São Paulo", "sao_paulo_sp", 2,  new BigDecimal(243.99));

        String imageName = aPackage.getImage();
        LoadImage(imageName);

        String localName = aPackage.getLocal();
        loadLocal(localName);

        int countDay = aPackage.getDays();
        loadNumberOfDays(countDay);

        BigDecimal tripPrice = aPackage.getPrice();
        loadPrice(countDay, tripPrice);

        loadTripRoundDate(countDay);
    }

    private void loadTripRoundDate(int days)
    {
        String RoundTrip  = DataUtil.DateRoundInString(days);
        TextView tripDuration = findViewById(R.id.resume_package_date);
        tripDuration.setText(RoundTrip);
    }
    private void loadPrice(int days, BigDecimal tripPrice) {
        String formatedPrice = CoinUtil.coinFormat(tripPrice);
        TextView price = findViewById(R.id.resume_package_price);
        price.setText(formatedPrice);
    }

    private void loadNumberOfDays(int countday) {
        String formatedDay = DayUtil.dayFormat(countday);
        TextView days = findViewById(R.id.resume_package_days);
        days.setText(formatedDay);
    }

    private void loadLocal(String localName) {
        TextView local = findViewById(R.id.resume_package_local);
        local.setText(localName);
    }

    private void LoadImage(String image) {
        Drawable drawableResource = ResourceUtil.getDrawableResource(image, this);
        ImageView localImage = findViewById(R.id.resume_package_local_image);
        localImage.setImageDrawable(drawableResource);
    }
}