
package com.example.proyecto_hotel.ui.home;

public class Categoria {
    private final  String idDrink;
    private final  String strDrink;
    private final  String strDrinkThumb;

    public Categoria(String idDrink, String strDrink, String strDrinkThumb) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.strDrinkThumb = strDrinkThumb;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }
}

