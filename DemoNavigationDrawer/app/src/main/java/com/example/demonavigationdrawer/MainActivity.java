package com.example.demonavigationdrawer;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // TODO(1): Add com.android.support:design:27.1.1 dependency
    // TODO(2): Add DrawerLayout with two child layout(Layout for content and NavigationView)

    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        item.setChecked(true);
                        FragmentManager manager = getSupportFragmentManager();
                        switch (item.getItemId()) {
                            case R.id.nav_camera:
                                manager.beginTransaction().replace(R.id.fragment_container, new FragmentImport()).commit();
                                break;
                            case R.id.nav_gallery:
                                manager.beginTransaction().replace(R.id.fragment_container, new FragmentGallery()).commit();
                                break;
                            case R.id.nav_slideshow:
                                manager.beginTransaction().replace(R.id.fragment_container, new FragmentSlideshow()).commit();
                                break;
                            case R.id.nav_manage:
                                manager.beginTransaction().replace(R.id.fragment_container, new FragmentTools()).commit();
                                break;
                        }

                        return true;
                    }
                }
        );




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
