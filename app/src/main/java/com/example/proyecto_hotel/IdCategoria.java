package com.example.proyecto_hotel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyecto_hotel.ui.cat.ListaCategorias;

import java.util.HashMap;
import java.util.Map;

public class IdCategoria extends AppCompatActivity implements View.OnClickListener {


    EditText tipox, caracteristicasx, img01x, preciox, num_habitacionesx, idx;
    Button btnCreate, btnFetch;

    RequestQueue requestQueue;

    private static final String Url1 = "http://192.168.18.5:5000/categorias/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_categoria);
        getSupportActionBar().hide();

        requestQueue = Volley.newRequestQueue(this);

        initUI();

        btnCreate.setOnClickListener(this);
        btnFetch.setOnClickListener(this);
    }

    private void initUI() {
        tipox = findViewById(R.id.tipox);
        caracteristicasx = findViewById(R.id.caracteristicasx);
        img01x = findViewById(R.id.img01x);
        preciox = findViewById(R.id.preciox);
        num_habitacionesx = findViewById(R.id.num_habitacionesx);
        idx = findViewById(R.id.idx);


        btnCreate = findViewById(R.id.btnCreate);
        btnFetch = findViewById(R.id.btnFetch);

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.btnCreate) {
            String tipo = tipox.getText().toString().trim();
            String caracteristicas = caracteristicasx.getText().toString().trim();
            String img01 = img01x.getText().toString().trim();
            String precio = preciox.getText().toString().trim();
            String num_habitaciones = num_habitacionesx .getText().toString().trim();

            createUser(tipo, caracteristicas, img01, precio, num_habitaciones );

            Intent intencion = new Intent( IdCategoria.this, ListaCategorias.class);
            startActivity(intencion);

        } else if (id == R.id.btnFetch) {
            Intent intent = new Intent(this, GetIdCategoria.class);
            intent.putExtra("id", idx.getText().toString().trim());
            startActivity(intent);

        }

    }


    private  void  createUser(final String tipo, final String caracteristicas, final String img01,final String precio, final String num_habitaciones  ) {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(IdCategoria.this, "Correct", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("tipo", tipo);
                params.put("caracteristicas", caracteristicas);
                params.put("img01", img01);
                params.put("precio", precio);
                params.put("num_habitaciones", num_habitaciones);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
