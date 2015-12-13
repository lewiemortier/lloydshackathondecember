package com.dminc.lloydshackathon2.Intents;

import android.content.Context;
import android.content.Intent;

import com.dminc.lloydshackathon2.Activites.AnotherActivity;

/**
 * @author Lewie Mortier
 */
public class AnotherIntent extends Intent {

    public AnotherIntent(Context ctx) {
        super(ctx, AnotherActivity.class);
    }
}
