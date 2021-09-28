package traveldreams.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import traveldreams.com.br.R;

public class PaymentActivity extends AppCompatActivity {

    public static final String APP_BAR_PAYMENT = "Payment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        setTitle(APP_BAR_PAYMENT);
    }
}