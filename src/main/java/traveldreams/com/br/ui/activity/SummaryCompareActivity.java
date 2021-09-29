package traveldreams.com.br.ui.activity;

import static traveldreams.com.br.model.PackageConst.PACKAGE_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import traveldreams.com.br.model.Package;
import traveldreams.com.br.R;
import traveldreams.com.br.util.CoinUtil;
import traveldreams.com.br.util.DataUtil;
import traveldreams.com.br.util.ResourceUtil;

public class SummaryCompareActivity extends AppCompatActivity {

    public static final String APP_BAR = "Summary of the buy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_compare);

        setTitle(APP_BAR);

        Intent intent = getIntent();
        if(intent.hasExtra(PACKAGE_KEY))
        {
            Package aPackage = (Package) intent.getSerializableExtra(PACKAGE_KEY);

            Drawable localImageResource = ResourceUtil.getDrawableResource(aPackage.getImage(), SummaryCompareActivity.this);
            ImageView  localImage = findViewById(R.id.trip_place_image);
            localImage.setImageDrawable(localImageResource);

            TextView localNameResource = findViewById(R.id.trip_local_name);
            localNameResource.setText(aPackage.getLocal());

            String roundTrip = DataUtil.DateRoundInString(aPackage.getDays());
            TextView roundTripResource = findViewById(R.id.trip_round_data);
            roundTripResource.setText(roundTrip);

            String tripPrice = CoinUtil.coinFormat(aPackage.getPrice());
            TextView tripPriceResource = findViewById(R.id.trip_price_price);
            tripPriceResource.setText(tripPrice);
        }
    }
}