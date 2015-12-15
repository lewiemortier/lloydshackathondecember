package com.dminc.lloydshackathon2.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * @author Lewie Mortier
 */
public class Utils {

    private static Locale DEFAULT_LOCALE = Locale.UK;

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

    public static String formatPrice(double price) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        numberFormat.setCurrency(Currency.getInstance(DEFAULT_LOCALE));
        return numberFormat.format(price);
    }
}
