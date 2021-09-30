package traveldreams.com.br.ui.activity;

import static traveldreams.com.br.model.PackageConst.PACKAGE_KEY;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import traveldreams.com.br.R;
import traveldreams.com.br.model.Package;
import traveldreams.com.br.util.CoinUtil;
import traveldreams.com.br.util.DataUtil;
import traveldreams.com.br.util.ResourceUtil;

public class SummaryCompareActivity extends AppCompatActivity {

    public static final String APP_BAR = "Summary of the buy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_compare);
        appBarConfig();
        Intent intent = getIntent();
        loadResources(intent);
    }

    private void loadResources(Intent intent) {
        if (intent.hasExtra(PACKAGE_KEY)) {
            Package aPackage = (Package) intent.getSerializableExtra(PACKAGE_KEY);
            loadTripImage(aPackage);
            loadTripLocalName(aPackage);
            loadTripRoundDate(aPackage);
            loadTripPrice(aPackage);
        }
    }

    private void loadTripPrice(Package aPackage) {
        String tripPrice = CoinUtil.coinFormat(aPackage.getPrice());
        TextView tripPriceResource = findViewById(R.id.trip_price_price);
        tripPriceResource.setText(tripPrice);
    }

    private void loadTripRoundDate(Package aPackage) {
        String roundTrip = DataUtil.DateRoundInString(aPackage.getDays());
        TextView roundTripResource = findViewById(R.id.trip_round_data);
        roundTripResource.setText(roundTrip);
    }

    private void loadTripLocalName(Package aPackage) {
        TextView localNameResource = findViewById(R.id.trip_local_name);
        localNameResource.setText(aPackage.getLocal());
    }

    private void loadTripImage(Package aPackage) {
        Drawable localImageResource = ResourceUtil.getDrawableResource(aPackage.getImage(), SummaryCompareActivity.this);
        ImageView localImage = findViewById(R.id.trip_place_image);
        localImage.setImageDrawable(localImageResource);
    }

    private void appBarConfig() {
        setTitle(APP_BAR);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

}