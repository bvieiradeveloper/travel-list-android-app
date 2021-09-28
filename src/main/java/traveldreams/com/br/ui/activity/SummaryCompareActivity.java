package traveldreams.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import traveldreams.com.br.R;

public class SummaryCompareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_compare);

        setTitle("Summary of the buy");
    }
}