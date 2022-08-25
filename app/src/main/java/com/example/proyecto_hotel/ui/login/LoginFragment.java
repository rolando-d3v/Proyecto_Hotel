package com.example.proyecto_hotel.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_hotel.R;
import com.example.proyecto_hotel.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText txtUsuario = binding.editTextPersonName;
        EditText txtPassword = binding.editTextPassword;

        NavController navController = Navigation.findNavController(binding.getRoot());

        binding.buttonLogin.setOnClickListener(view1 -> {
            if(txtUsuario.getText().toString().equals("") || txtPassword.getText().toString().equals("")){
                Toast.makeText(requireContext(),"Ingresar sus credenciales correctos", Toast.LENGTH_LONG).show();
            } else {
                navController.navigate(R.id.navigation_home);
                Toast.makeText(requireContext(),"Bienvenido Jorge", Toast.LENGTH_LONG).show();
            }

        });

    }
}