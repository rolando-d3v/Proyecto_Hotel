package com.example.proyecto_hotel.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyecto_hotel.R;

import java.util.List;

public class AdapterCategoria  extends RecyclerView.Adapter<AdapterCategoria.ViewHolder> {

    private final List<Categoria> listaCategorias;

    public AdapterCategoria(List<Categoria> listaCoCategorias) {
        this.listaCategorias = listaCoCategorias;
    }

    @NonNull
    @Override
    public AdapterCategoria.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_categorias, parent,false);
        return new AdapterCategoria.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCategoria.ViewHolder holder, int position) {

        String urlImagen = listaCategorias.get(position).getStrDrinkThumb();
        String nombreImagen = listaCategorias.get(position).getStrDrink();

        holder.nombreCoctel.setText(nombreImagen);

        Glide.with(holder.itemView.getContext())
                .load(urlImagen)
                .centerCrop()
                .placeholder(R.drawable.bed_icon)
                .into(holder.imagenCoctel);
//
//        holder.itemView.setOnClickListener(v -> {
//            Bundle bundle = new Bundle();
//            bundle.putString(Constantes.ID_COCTEL, listaCategorias.get(position).getIdDrink());
//            bundle.putString(Constantes.URL_IMAGEN, urlImagen);
//            Navigation.findNavController(v).navigate(R.id.detalleCoctelFragment, bundle);
//        });
    }

    @Override
    public int getItemCount() {
        return listaCategorias.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imagenCoctel;
        private final TextView nombreCoctel;

        public ViewHolder(@NonNull View view) {
            super(view);
            imagenCoctel = view.findViewById(R.id.imagenCoctel);
            nombreCoctel = view.findViewById(R.id.nombreCoctel);
        }
    }

}
