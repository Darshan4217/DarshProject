package com.example.lenovo.myapplication;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.lenovo.myapplication.Country.CountryDetailFragment;
import com.example.lenovo.myapplication.Country.CountryFragment;

public class DashBoardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        //Add to back stack is not called because it shows empty framelayout
        Fragment fragment = new CountryFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_layout, fragment)
                .commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            // This code is written for toolbar Updation when back button pressed
            Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(getClass().getSimpleName());
            if (currentFragment instanceof CountryDetailFragment) {

            }

            int count = getSupportFragmentManager().getBackStackEntryCount();
            if (count > 0) {
                getSupportFragmentManager().popBackStack();
            } else {
                if (doubleBackToExitPressedOnce) {
                    finish();
                    return;
                }

                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            }
        }
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

            //Add to back stack is not called because it shows empty framelayout and hide
            //hide method called becuase firt time country fragment added whithout clicking on menu so need to remove
            Fragment fragment = new CountryFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_layout, fragment, fragment.getClass().getSimpleName())
                    .hide(fragment).commit();

        } else if (id == R.id.nav_Opportunity) {

        } else if (id == R.id.nav_Gallery) {

        } else if (id == R.id.nav_AboutUs) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showToolbarBackArrow(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void hideToolbarBackArrow(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void addFragment(Fragment currentFragment, Fragment newFragment){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_layout, newFragment)
                .addToBackStack(null)
                .hide(currentFragment)
                .commit();
    }
}