package com.example.proyecto_hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoReserva extends AppCompatActivity  implements View.OnClickListener{

    private Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_reserva);

        getSupportActionBar().hide();
        boton1=(Button) findViewById(R.id.btn_editar_reserva);
        boton1.setOnClickListener(this);
    }

    @Override
    public void  onClick(View v) {
        Intent intencion = new Intent(this,EditarReserva.class);
        startActivity(intencion);
    }
}