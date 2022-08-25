package com.example.proyecto_hotel.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.proyecto_hotel.R;
import com.example.proyecto_hotel.databinding.FragmentHomeBinding;
import com.example.proyecto_hotel.ui.infocuarto.InfoCuartoFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(binding.getRoot());
        binding.button.setOnClickListener(view1 -> {
            navController.navigate(R.id.navigation_agregarServicioFragment);
        });

        binding.buttonSuit.setOnClickListener(view1 -> {
            navController.navigate(R.id.navigation_agregarServicioFragment);
        });

        binding.buttonPlata.setOnClickListener(view1 -> {
            navController.navigate(R.id.navigation_agregarServicioFragment);
        });

        binding.buttonCamaDoble.setOnClickListener(view1 -> {
            navController.navigate(R.id.navigation_agregarServicioFragment);
        });

        binding.button2.setOnClickListener(view1 -> {
            navController.navigate(R.id.navigation_infoCuartoFragment);
        });

        binding.buttonCamaDoble2.setOnClickListener(view1 -> {
            navController.navigate(R.id.navigation_infoCuartoFragment);
        });

        binding.buttonPlata2.setOnClickListener(view1 -> {
            navController.navigate(R.id.navigation_infoCuartoFragment);
        });

        binding.buttonSuit2.setOnClickListener(view1 -> {
            navController.navigate(R.id.navigation_infoCuartoFragment);
        });

    }

}