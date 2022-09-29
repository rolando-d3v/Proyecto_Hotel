package com.example.proyecto_hotel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyecto_hotel.ui.cat.ListaCategorias;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GetIdCategoria extends AppCompatActivity implements View.OnClickListener {


    EditText tipox, caracteristicasx, img01x, preciox, num_habitacionesx, idx;
    Button btnEdit, btnDelete;
    String id;

    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_id_categoria);

        getSupportActionBar().hide();

        requestQueue = Volley.newRequestQueue(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getString("id");
        }
        initUI();
        readUser();

        btnEdit.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }


    private void initUI() {
        tipox = findViewById(R.id.tipox);
        caracteristicasx = findViewById(R.id.caracteristicasx);
        img01x = findViewById(R.id.img01x);
        preciox = findViewById(R.id.preciox);
        num_habitacionesx = findViewById(R.id.num_habitacionesx);
        idx = findViewById(R.id.idx);


        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);

    }


    private  void  readUser() {
        String Url = "http://192.168.18.5:5000/categorias/" + id ;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                Url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String tipo, caracteristicas, img01, precio, num_habitaciones;

                        try {
                            tipo = response.getString("tipo");
                            caracteristicas = response.getString("caracteristicas");
                            img01 = response.getString("img01");
                            precio = response.getString("precio");
                            num_habitaciones = response.getString("num_habitaciones");

                            tipox.setText(tipo);
                            caracteristicasx.setText(caracteristicas);
                            img01x.setText(img01);
                            preciox.setText(precio);
                            num_habitacionesx.setText(num_habitaciones);
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }


    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.btnEdit) {

        } else  if (id == R.id.btnDelete) {
            String idCat = idx.getText().toString().trim();

            removerCat(idCat);
        }

    }


    private void  removerCat(String idCat) {
        String Url02 = "http://192.168.18.5:5000/categorias/"+ idCat ;
        StringRequest stringRequest = new StringRequest(
                Request.Method.DELETE,
                Url02,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Intent intencion = new Intent( GetIdCategoria.this, ListaCategorias.class);
                        startActivity(intencion);
                        finish();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idCat);
                return params;
            }
        } ;

        requestQueue.add(stringRequest);

    }
}