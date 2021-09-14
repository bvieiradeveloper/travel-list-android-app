package traveldreams.com.br.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {

    public final static Drawable getDrawableResource(String drawableName, Context context)
    {
        Resources resources = context.getResources();
        int imageResourceId = resources.getIdentifier(drawableName, "drawable", context.getPackageName());
        Drawable imageResource = resources.getDrawable(imageResourceId);
        return imageResource;
    }
}
