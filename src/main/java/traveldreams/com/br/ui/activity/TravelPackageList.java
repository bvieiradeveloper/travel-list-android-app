package traveldreams.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import traveldreams.com.br.R;
import traveldreams.com.br.DAO.PackageDAO;
import traveldreams.com.br.ui.adapter.PackageListOptions;

public class TravelPackageList extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Packages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_package_list);
        setTitle(TITLE_APPBAR);
        ListView packageList = findViewById(R.id.package_list);
        PackageDAO packageDAO = new PackageDAO();
        packageList.setAdapter(new PackageListOptions(packageDAO,this));

        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }
}