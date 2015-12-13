package com.dminc.lloydshackathon2.Activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dminc.lloydshackathon2.Fragments.HomeFragment;
import com.dminc.lloydshackathon2.R;

/**
 * @author Lewie Mortier
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, new HomeFragment())
                .commit();
    }
}
