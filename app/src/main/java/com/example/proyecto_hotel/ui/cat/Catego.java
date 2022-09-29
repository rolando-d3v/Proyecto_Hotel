package com.example.proyecto_hotel.ui.cat;

public class Catego {

        private final  String tipo;
        private final  String caracteristicas;
        private final  String img01;
        private final  String precio;



    public Catego(String tipo, String caracteristicas, String img01, String precio) {
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.img01 = img01;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public String getImg01() {
        return img01;
    }

    public String getPrecio() {
        return precio;
    }
}
