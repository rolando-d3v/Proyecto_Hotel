package com.example.proyecto_hotel.ui.infocuarto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyecto_hotel.R;
import com.example.proyecto_hotel.databinding.FragmentAgregarServicioBinding;
import com.example.proyecto_hotel.databinding.FragmentInfoCuartoBinding;

public class AgregarServicioFragment extends Fragment {

    private FragmentAgregarServicioBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAgregarServicioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText txtPrecio = binding.editTextPrecioAgregado;

        NavController navController = Navigation.findNavController(binding.getRoot());

        binding.buttonRomantico.setOnClickListener(view1 -> {
            txtPrecio.setText("Precio: S/300.00");
        });

        binding.buttonCumpleanos.setOnClickListener(view1 -> {
            txtPrecio.setText("Precio: S/200.00");

        });

        binding.buttonGraduacion.setOnClickListener(view1 -> {
            txtPrecio.setText("Precio: S/100.00");
        });

        binding.buttonContinuar.setOnClickListener(view1 -> {
            navController.navigate(R.id.navigation_registrarReservaFragment);
        });

    }

}