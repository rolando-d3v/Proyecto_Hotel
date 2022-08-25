package com.example.proyecto_hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Portada extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);
        getSupportActionBar().hide();

    }

    @Override
    public void  onClick(View v) {

        Intent intencion=null;

        switch (v.getId()) {
            case  R.id.btn_ir_login:
                intencion = new Intent( Portada.this, Ubicacion.class);
                break;

            case  R.id.btn_registrarse:
                intencion = new Intent(Portada.this,MainActivity.class);
                break;
        }
        startActivity(intencion);
    }





}




























//    private Button boton1;
//    private Button boton2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_portada);
//        getSupportActionBar().hide();
//
//        boton1=(Button) findViewById(R.id.btn_ir_login);
//        boton1.setOnClickListener(this);
//
//        boton2=(Button) findViewById(R.id.btn_registrarse);
//        boton2.setOnClickListener(this);
//    }
//
//    @Override
//    public void  onClick(View v) {
//        Intent intencion = new Intent( Portada.this, Ubicacion.class);
//        startActivity(intencion);
//    }
//
//
//    public void  onClicked(View v) {
//        Intent intencionx = new Intent(Portada.this,MainActivity.class);
//        startActivity(intencionx);
//
//    }

