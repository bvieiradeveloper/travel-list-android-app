package traveldreams.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import traveldreams.com.br.R;
import traveldreams.com.br.model.Package;
import traveldreams.com.br.util.CoinUtil;
import traveldreams.com.br.util.DayUtil;
import traveldreams.com.br.util.ResourceUtil;

public class ResumePackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_package);

        setTitle("Package Resume");

        final Package aPackage = new Package("São Paulo", "sao_paulo_sp", 2,  new BigDecimal(243.99));
        Drawable drawableResource = ResourceUtil.getDrawableResource(aPackage.getImage(), this);

        ImageView localImage = findViewById(R.id.resume_package_local_image);
        localImage.setImageDrawable(drawableResource);

        TextView local = findViewById(R.id.resume_package_local);
        local.setText(aPackage.getLocal());

        String formatedDay = DayUtil.dayFormat(aPackage.getDays());
        TextView days = findViewById(R.id.resume_package_days);
        days.setText(formatedDay);

        String formatedPrice = CoinUtil.coinFormat(aPackage.getPrice());
        TextView price = findViewById(R.id.resume_package_price);
        price.setText(formatedPrice);

        Calendar departureDate  = Calendar.getInstance();
        Calendar returnDate  = Calendar.getInstance();
        returnDate.add(returnDate.DATE,aPackage.getDays());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");

        String RoundTrip = dateFormat.format(departureDate.getTime()) + " - " + dateFormat.format(returnDate.getTime()) + " at " + returnDate.get(Calendar.YEAR);

        TextView tripDuration = findViewById(R.id.resume_package_date);
        tripDuration.setText(RoundTrip);

    }
}