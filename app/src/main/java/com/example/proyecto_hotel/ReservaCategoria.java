package com.example.proyecto_hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyecto_hotel.ui.cat.ListaCategorias;

import org.json.JSONException;
import org.json.JSONObject;

public class ReservaCategoria extends AppCompatActivity {

    private EditText tipo, caracteristicas, img01, img02, precio, num_habitaciones  ;
    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_categoria);
        getSupportActionBar().hide();

        tipo=findViewById(R.id.tipo);
        caracteristicas=findViewById(R.id.caracteristicas);
        img01=findViewById(R.id.img01);
        img02=findViewById(R.id.img02);
        precio=findViewById(R.id.precio);
        num_habitaciones=findViewById(R.id.num_habitaciones);

        rq= Volley.newRequestQueue(this);

    }

    public  void  insertar(View v) {
        String url = "http://192.168.18.5:5000/categorias";
        JSONObject parametros=new JSONObject();
        try {
            parametros.put("tipo", tipo.getText().toString() );
            parametros.put("caracteristicas", caracteristicas.getText().toString() );
            parametros.put("img01", img01.getText().toString() );
            parametros.put("img02", img02.getText().toString() );
            parametros.put("precio", precio.getText().toString() );
            parametros.put("num_habitaciones", num_habitaciones.getText().toString() );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest requerimiento= new JsonObjectRequest(Request.Method.POST,
                url, parametros,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.get("respuesta").toString().equals("oks")) {
                                Toast.makeText(ReservaCategoria.this, "los datos correct", Toast.LENGTH_LONG).show();
                                tipo.setText("");
                                caracteristicas.setText("");
                                img01.setText("");
                                img02.setText("");
                                precio.setText("");
                                num_habitaciones.setText("");
                            }
                            else
                                Toast.makeText(ReservaCategoria.this, "problemas datos correct", Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void  onErrorResponse(VolleyError error) {
                     Toast.makeText(ReservaCategoria.this, "Problema", Toast.LENGTH_LONG).show();

                  }
                });
        rq.add(requerimiento);
    }

    public  void  IrReserva(View v) {
        Intent intencion = new Intent(this, ListaCategorias.class);
        startActivity(intencion);
    }


    public  void  IdCategoria(View v) {
        Intent intencion = new Intent(this, IdCategoria.class);
        startActivity(intencion);
    }

}