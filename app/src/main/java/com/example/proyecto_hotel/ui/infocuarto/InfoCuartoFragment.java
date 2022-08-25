package com.example.proyecto_hotel.ui.infocuarto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proyecto_hotel.R;
import com.example.proyecto_hotel.databinding.FragmentHomeBinding;
import com.example.proyecto_hotel.databinding.FragmentInfoCuartoBinding;

public class InfoCuartoFragment extends Fragment {

    private FragmentInfoCuartoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);
        binding = FragmentInfoCuartoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(binding.getRoot());

        TextView textView = binding.textVerCuarto;
        textView.setText("Vista de cuarto");
    }

}