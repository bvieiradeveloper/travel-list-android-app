package traveldreams.com.br.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import traveldreams.com.br.DAO.PackageDAO;
import traveldreams.com.br.R;
import traveldreams.com.br.util.CoinUtil;
import traveldreams.com.br.util.DayUtil;
import traveldreams.com.br.util.ResourceUtil;

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
        View createdView = getView(viewGroup);
        createLocal(position, createdView);
        createDays(position, createdView);
        createCoin(position, createdView);
        createImage(position, createdView);
        return createdView;
    }

    private View getView(ViewGroup viewGroup) {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.item_package, viewGroup, false);
        return createdView;
    }

    private void createImage(int position, View createdView) {
        ImageView image= createdView.findViewById(R.id.item_package_image_local);
        Drawable imageResource = ResourceUtil.getDrawableResource(packageDAO.list().get(position).getImage(), context);
        image.setImageDrawable(imageResource);
    }

    private void createCoin(int position, View createdView) {
        String formattedPrice = CoinUtil.coinFormat(packageDAO.list().get(position).getPrice());
        TextView price = createdView.findViewById(R.id.item_package_price);
        price.setText(formattedPrice);
    }

    private void createDays(int position, View createdView) {
        TextView days = createdView.findViewById(R.id.item_package_days);
        String day = DayUtil.dayFormat(packageDAO.list().get(position).getDays());
        days.setText(day);
    }

    private void createLocal(int position, View createdView) {
        TextView local = createdView.findViewById(R.id.item_package_local);
        local.setText(packageDAO.list().get(position).getLocal());
    }
}
