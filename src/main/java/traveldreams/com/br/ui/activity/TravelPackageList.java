package traveldreams.com.br.ui.activity;

import static traveldreams.com.br.model.PackageConst.PACKAGE_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import traveldreams.com.br.R;
import traveldreams.com.br.DAO.PackageDAO;
import traveldreams.com.br.model.Package;
import traveldreams.com.br.ui.adapter.PackageListOptions;

public class TravelPackageList extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Packages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_package_list);
        setTitle(TITLE_APPBAR);
        listConfig();
    }

    private void listConfig() {
        ListView packageList = findViewById(R.id.package_list);
        final PackageDAO packageDAO = new PackageDAO();
        packageList.setAdapter(new PackageListOptions(packageDAO,this));

        packageList.setOnItemClickListener((adapterView, view, position, id) ->
        {
            final Package aPackage = packageDAO.list().get(position);
            Intent intent = new Intent(TravelPackageList.this, ResumePackageActivity.class);
            intent.putExtra(PACKAGE_KEY, aPackage);
            startActivity(intent);
        });
    }
}