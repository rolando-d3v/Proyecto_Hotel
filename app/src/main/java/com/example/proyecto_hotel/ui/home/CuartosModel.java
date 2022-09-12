package com.example.proyecto_hotel.ui.home;

public class CuartosModel {
    private int id;
    private String nombreCuarto;
    private String descripcionCuarto;
    private String precio;

    public CuartosModel(int id, String nombreCuarto, String descripcionCuarto, String precio) {
        this.id = id;
        this.nombreCuarto = nombreCuarto;
        this.descripcionCuarto = descripcionCuarto;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCuarto() {
        return nombreCuarto;
    }

    public void setNombreCuarto(String nombreCuarto) {
        this.nombreCuarto = nombreCuarto;
    }

    public String getDescripcionCuarto() {
        return descripcionCuarto;
    }

    public void setDescripcionCuarto(String descripcionCuarto) {
        this.descripcionCuarto = descripcionCuarto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
