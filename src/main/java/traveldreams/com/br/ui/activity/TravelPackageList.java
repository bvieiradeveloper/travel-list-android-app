package traveldreams.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import traveldreams.com.br.R;
import traveldreams.com.br.ui.DAO.PackageDAO;
import traveldreams.com.br.ui.adapter.PackageListOptions;

public class TravelPackageList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_package_list);
        setTitle("Packages");
        ListView packageList = findViewById(R.id.package_list);
        PackageDAO packageDAO = new PackageDAO();
        packageList.setAdapter(new PackageListOptions(packageDAO,this));
    }
}