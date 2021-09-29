package traveldreams.com.br.ui.activity;

import static traveldreams.com.br.model.PackageConst.PACKAGE_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

import traveldreams.com.br.R;
import traveldreams.com.br.model.Package;
import traveldreams.com.br.util.CoinUtil;

public class PaymentActivity extends AppCompatActivity {

    public static final String APP_BAR_PAYMENT = "Payment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle(APP_BAR_PAYMENT);

        Intent intent = getIntent();
        if(intent.hasExtra(PACKAGE_KEY))
        {
            Package aPackage = (Package) intent.getSerializableExtra(PACKAGE_KEY);
            String formattedPrice = CoinUtil.coinFormat(aPackage.getPrice());
            TextView price = findViewById(R.id.trip_price);
            price.setText(formattedPrice);
            btnConfig(aPackage);
        }


    }

    private void btnConfig(Package aPackage) {
        Button finishPurchase = findViewById(R.id.finish_payment);
        finishPurchase.setOnClickListener(view ->
        {
            Intent intent = new Intent(PaymentActivity.this,SummaryCompareActivity.class);
            intent.putExtra(PACKAGE_KEY,aPackage);
            startActivity(intent);
        });
    }
}