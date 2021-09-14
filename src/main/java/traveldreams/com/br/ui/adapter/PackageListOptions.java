package traveldreams.com.br.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import traveldreams.com.br.R;
import traveldreams.com.br.ui.DAO.PackageDAO;
import traveldreams.com.br.ui.activity.TravelPackageList;

public class PackageListOptions extends BaseAdapter {

    Context context;
    PackageDAO packageDAO;
    public PackageListOptions(PackageDAO packageDAO, Context context) {
        this.context = context;
        this.packageDAO = packageDAO;
    }

    @Override
    public int getCount() {
        return packageDAO.list().size();
    }

    @Override
    public Object getItem(int position) {
        return packageDAO.list().get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.item_package, viewGroup, false);

        TextView local = createdView.findViewById(R.id.item_package_local);
        local.setText(packageDAO.list().get(position).getLocal());

        TextView days = createdView.findViewById(R.id.item_package_days);
        int day = packageDAO.list().get(position).getDays();
        days.setText( day == 1 ? day + " day" : day + " days");

        NumberFormat currencyCoinFormat = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String formattedPrice = currencyCoinFormat.format(packageDAO.list().get(position).getPrice()).replace("R$", "R$ ");
        TextView price = createdView.findViewById(R.id.item_package_price);
        price.setText(formattedPrice);

        ImageView image= createdView.findViewById(R.id.item_package_image_local);
        Resources resources = context.getResources();
        int imageResourceId = resources.getIdentifier(packageDAO.list().get(position).getImage(), "drawable", context.getPackageName());
        Drawable imageResource = resources.getDrawable(imageResourceId);
        image.setImageDrawable(imageResource);

        return createdView;
    }
}
