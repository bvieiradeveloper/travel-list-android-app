package traveldreams.com.br.ui.activity;

import static traveldreams.com.br.model.PackageConst.PACKAGE_KEY;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import traveldreams.com.br.R;
import traveldreams.com.br.model.Package;
import traveldreams.com.br.util.CoinUtil;
import traveldreams.com.br.util.DataUtil;
import traveldreams.com.br.util.DayUtil;
import traveldreams.com.br.util.ResourceUtil;

public class ResumePackageActivity extends AppCompatActivity {

    public static final String APP_BAR = "Package Resume";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_package);
        setTitle(APP_BAR);

        Intent intent = getIntent();
        loadResources(intent);
    }

    private void loadResources(Intent intent) {
        if (intent.hasExtra(PACKAGE_KEY)) {
            Package aPackage = (Package) intent.getSerializableExtra(PACKAGE_KEY);
            LoadIntent(aPackage);
            btnConfig(aPackage);
        }
    }

    private void LoadIntent(Package aPackage) {

        LoadImage(aPackage.getImage());
        loadLocal(aPackage.getLocal());
        loadNumberOfDays(aPackage.getDays());
        loadPrice(aPackage.getDays(), aPackage.getPrice());
        loadTripRoundDate(aPackage.getDays());
    }

    private void btnConfig(Package aPackage) {
        Button paymentDetails = findViewById(R.id.payment_details);
        paymentDetails.setOnClickListener(view ->
        {
            Intent intent = new Intent(ResumePackageActivity.this, PaymentActivity.class);
            intent.putExtra(PACKAGE_KEY, aPackage);
            startActivity(intent);
        });
    }

    private void loadTripRoundDate(int days) {
        String RoundTrip = DataUtil.DateRoundInString(days);
        TextView tripDuration = findViewById(R.id.resume_package_date);
        tripDuration.setText(RoundTrip);
    }

    private void loadPrice(int days, BigDecimal tripPrice) {
        String formattedPrice = CoinUtil.coinFormat(tripPrice);
        TextView price = findViewById(R.id.resume_package_price);
        price.setText(formattedPrice);
    }

    private void loadNumberOfDays(int countDay) {
        String formattedDay = DayUtil.dayFormat(countDay);
        TextView days = findViewById(R.id.resume_package_days);
        days.setText(formattedDay);
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