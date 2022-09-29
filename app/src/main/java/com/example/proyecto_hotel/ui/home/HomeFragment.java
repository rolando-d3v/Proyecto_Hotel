package com.example.proyecto_hotel.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyecto_hotel.R;
import com.example.proyecto_hotel.databinding.FragmentHomeBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;









public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RequestQueue cola;
    private  String url;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerCategoria.setLayoutManager( new LinearLayoutManager(requireContext()));

        List<String> listaCategoriasHotel = new ArrayList<>();
        listaCategoriasHotel.add("Pisco");
        listaCategoriasHotel.add("Rum");
        listaCategoriasHotel.add("Tequila");
        listaCategoriasHotel.add("Vodka");


        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(requireContext(), R.layout.spinner_item, listaCategoriasHotel );
        binding.spinnerCat.setAdapter(adapterSpinner);
        binding.spinnerCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String cat = binding.spinnerCat.getSelectedItem().toString();
                url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=" + cat;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        binding.btnBuscar.setOnClickListener( v->{
            JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                    response -> {
                        try {

                            JSONArray jsonArray = response.getJSONArray("drinks");
                            Gson gson = new Gson();
                            Type listType = new TypeToken<ArrayList<Categoria>>() {}.getType();

                            List<Categoria> listaCategorias = gson.fromJson(String.valueOf(jsonArray), listType);
                            AdapterCategoria miAdapter = new AdapterCategoria(listaCategorias);
                            binding.recyclerCategoria.setAdapter(miAdapter);

//                            recyclerView.setAdapter(miAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    },
                    error -> Toast.makeText(requireContext(), "Error al traer los datos: " + error.toString(), Toast.LENGTH_LONG).show()
            );

            cola.add(jsonRequest);
        } ) ;

        cola = Volley.newRequestQueue(requireContext());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}