package com.example.proyecto_hotel.ui.cat;

import android.content.Context;
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

public class CategoAdapter extends RecyclerView.Adapter<CategoAdapter.ProductViewHolder> {
    private Context mCtx;
    private List<Catego> productList;

    public CategoAdapter(Context mCtx, List<Catego> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public CategoAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorias, parent,false);
        return new CategoAdapter.ProductViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Catego product = productList.get(position);


        Glide.with(mCtx)
                .load(product.getImg01())
                .into(holder.imageView );


        holder.textViewTitle.setText(product.getTipo());
        holder.textViewPrice.setText( " $ " + product.getPrecio() );
        holder.textViewShortDesc.setText(product.getCaracteristicas());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView ;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
//            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
