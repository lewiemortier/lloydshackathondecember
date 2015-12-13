package com.dminc.lloydshackathon2.Activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.dminc.lloydshackathon2.Fragments.HomeFragment;
import com.dminc.lloydshackathon2.Intents.AnotherIntent;
import com.dminc.lloydshackathon2.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Lewie Mortier
 */
public class HomeDrawerActivity extends AppCompatActivity {

    @Bind(R.id.navigation_drawer)
    NavigationView mNavigationView;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);

                Intent intent;

                switch (item.getItemId()) {
                    case R.id.menu_item_1:
                        mDrawerLayout.closeDrawers();
                        return true;
                    case R.id.menu_item_2:
                        intent = new AnotherIntent(HomeDrawerActivity.this);
                        break;
                    default:
                        return false;
                }

                startActivity(intent);

                mDrawerLayout.closeDrawers();

                return true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
