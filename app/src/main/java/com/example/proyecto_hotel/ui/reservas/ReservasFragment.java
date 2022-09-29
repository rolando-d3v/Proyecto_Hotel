package com.example.proyecto_hotel.ui.reservas;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.example.proyecto_hotel.InfoReserva;
import com.example.proyecto_hotel.R;


public class ReservasFragment extends Fragment  {



    Activity context;
    private ReservasViewModel mViewModel;
    private RequestQueue cola;


    public static ReservasFragment newInstance() {
        return new ReservasFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,

                             @Nullable Bundle savedInstanceState) {

        context = getActivity();


        return inflater.inflate(R.layout.fragment_reservas, container, false);
    }


    public void  onStart() {
        super.onStart();
        Button btn = (Button) context.findViewById(R.id.btn_verMas);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion = new Intent(context, InfoReserva.class);
                startActivity(intencion);
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ReservasViewModel.class);

        // TODO: Use the ViewModel
    }


}