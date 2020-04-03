package com.example.user.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //kode untuk mendeklarasikan BottomNavigationView
        BottomNavigationView navigationView = findViewById(R.id.btn_nav);

        //kode untuk membuat trigger navigationView jika di klik
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //kode untuk get item id
                int id = menuItem.getItemId();

                //kode untuk membuat fragment home muncul
                if (id == R.id.home) {

                    HomeFragment fragment = new HomeFragment();

                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, fragment);
                    fragmentTransaction.commit();
                }

                //kode untuk membuat fragment favorite muncul
                if (id == R.id.favorite) {

                    FavoriteFragment fragment = new FavoriteFragment();

                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, fragment);
                    fragmentTransaction.commit();
                }

                //kode untuk membuat fragment profile muncul
                if (id == R.id.profile) {

                    ProfileFragment fragment = new ProfileFragment();

                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, fragment);
                    fragmentTransaction.commit();
                }

                return true;
            }
        });
        //kode untuk membuat home jadi default (keluar pertama kali)
        navigationView.setSelectedItemId(R.id.home);
    }

}
