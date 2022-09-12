package com.example.proyecto_hotel.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.proyecto_hotel.R;
import com.example.proyecto_hotel.databinding.FragmentHomeBinding;
import com.example.proyecto_hotel.ui.infocuarto.InfoCuartoFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RequestQueue cola;
    private String url;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //List<CuartosModel> listaUsuarios = getListaCuartos();
        //RecyclerView.Adapter<CuartoAdapter.ViewHolder> adapter  = new CuartoAdapter(listaUsuarios);
        binding.recyclerViewCuartos.setLayoutManager(new LinearLayoutManager(requireContext()));
        /*****************************************************************************/
        cola = Volley.newRequestQueue(requireContext());
        String url = "http://localhost:8086/hoteles/api/cuarto/listado";

        JsonObjectRequest jsonrequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        Gson gson = new Gson();
                        Type type = new TypeToken<ArrayList<CuartosModel>>(){}.getType();
                        List<CuartosModel> listaCuartos = gson.fromJson(String.valueOf(jsonArray),type);
                        CuartoAdapter adapterRecyclerview = new CuartoAdapter(listaCuartos);
                        binding.recyclerViewCuartos.setAdapter(adapterRecyclerview);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Toast.makeText(requireContext(),"Error: "+error.toString(), Toast.LENGTH_SHORT);
                });

        cola.add(jsonrequest);
        /*****************************************************************************/



    }

    private List<CuartosModel> getListaCuartos() {
        List<CuartosModel> userModels = new ArrayList<>();
        userModels.add(new CuartosModel(1,"Cuarto Premium Oro","Cuarto de dos plazas","S/.360.00"));
        userModels.add(new CuartosModel(2,"Cuarto Plata","Cuarto de dos plazas","S/.300.00"));
        userModels.add(new CuartosModel(3,"Cuarto Cama Doble","Cuarto de dos plazas","S/.250.00"));
        userModels.add(new CuartosModel(4,"Cuarto Suit","Cuarto de dos plazas","S/.100.00"));

        return userModels;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}