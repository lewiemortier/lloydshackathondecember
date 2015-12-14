package com.dminc.lloydshackathon2.Activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dminc.lloydshackathon2.Fragments.BuyFragment;
import com.dminc.lloydshackathon2.R;

/**
 * @author Lewie Mortier
 */
public class BuyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, new BuyFragment())
                .commit();

    }
}
