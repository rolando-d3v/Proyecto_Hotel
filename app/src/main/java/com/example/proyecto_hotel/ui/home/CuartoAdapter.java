package com.example.proyecto_hotel.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_hotel.R;

import java.util.List;

public class CuartoAdapter extends RecyclerView.Adapter<CuartoAdapter.ViewHolder> {

    private final List<CuartosModel> listaCuartos;

    public CuartoAdapter(List<CuartosModel> lista) {
        this.listaCuartos = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_cuartos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Context context = holder.itemView.getContext();
        holder.name.setText(listaCuartos.get(position).getNombreCuarto());
        holder.descripcion.setText(listaCuartos.get(position).getDescripcionCuarto());
        holder.precio.setText(listaCuartos.get(position).getPrecio());

        if(listaCuartos.get(position).getId() == 1)
            holder.img.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.cuarto1));
        else if(listaCuartos.get(position).getId() == 2)
            holder.img.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.cuarto2));

    }

    @Override
    public int getItemCount() {
        return listaCuartos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView descripcion;
        private final TextView precio;
        private final ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtNomCuarto);
            descripcion = itemView.findViewById(R.id.txtDescripcion);
            precio = itemView.findViewById(R.id.txtPrecio);
            img = itemView.findViewById(R.id.imgFoto);
        }
    }

}
