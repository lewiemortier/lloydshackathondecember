package com.dminc.lloydshackathon2.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * @author Lewie Mortier
 */
public class Utils {
    /**
     * Converts dip to pixels.
     *
     * @param context context to get {@link Resources} from.
     * @param dps     value to be converted
     * @return pixel value of {@code dps}.
     */
    public static int dip(final Context context, final int dps) {
        Resources r = context.getResources();
        return (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, dps, r.getDisplayMetrics());
    }
}
