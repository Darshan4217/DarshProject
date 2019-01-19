package com.example.lenovo.myapplication;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.lenovo.myapplication.Country.CountryFragment;
import com.example.lenovo.myapplication.base.BaseActivity;
import com.example.lenovo.myapplication.notification.NotificationFragment;

public class DashBoardActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Toolbar toolbar;
    public ActionBarDrawerToggle toggle;

    DrawerLayout drawerLayout;

    private void setupDrawerAndToggle() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setDrawerIndicatorEnabled(true);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        setupDrawerAndToggle();
        //toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.baseline_menu));

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        add(CountryFragment.newInstance());
    }


    @Override
    protected DrawerLayout getDrawer() {
        return drawerLayout;
    }

    @Override
    protected ActionBarDrawerToggle getDrawerToggle() {
        return toggle;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dash_board, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Notifications) {
            return true;
        }
        if(id == android.R.id.home){
            Toast.makeText(this, "Back from fragment", Toast.LENGTH_SHORT).show();
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Country) {
            add(CountryFragment.newInstance());

        } else if (id == R.id.nav_Notification) {
            add(NotificationFragment.newInstance());

        } else if (id == R.id.nav_Gallery) {

        } else if (id == R.id.nav_AboutUs) {

        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
