package com.example.proyecto_hotel;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyecto_hotel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_reservas, R.id.navigation_calificacion, R.id.navigation_user, R.id.navigation_infoCuartoFragment,
                R.id.navigation_agregarServicioFragment, R.id.navigation_registrarReservaFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);



        navController.addOnDestinationChangedListener((navController1, navDestination, bundle) -> {
            if(navDestination.getId() == R.id.navigation_login) {
                navView.setVisibility(View.GONE);
                getSupportActionBar().hide();
            } else if (navDestination.getId() == R.id.navigation_infoCuartoFragment || navDestination.getId() == R.id.navigation_agregarServicioFragment
                    || navDestination.getId() == R.id.navigation_registrarReservaFragment){
                navView.setVisibility(View.GONE);
            } else {
                navView.setVisibility(View.VISIBLE);
                getSupportActionBar().show();
                //getSupportActionBar().setTitle("Hello world App");
            }
        });
    }

}