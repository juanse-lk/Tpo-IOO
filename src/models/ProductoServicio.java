package models;

import models.enums.TipoIva;
import models.enums.Unidad;

public class ProductoServicio {

    // Atributos

    private Unidad unidad;
    private float precioUnidad;
    private TipoIva tipoIva;
    private String idProductoServicio;


    // Metodos

    // Getters
    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }


    // Setters
    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public TipoIva getTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(TipoIva tipoIva) {
        this.tipoIva = tipoIva;
    }

    public String getIdProductoServicio() {
        return idProductoServicio;
    }

    public void setIdProductoServicio(String idProductoServicio) {
        this.idProductoServicio = idProductoServicio;
    }

    // Funciones de ProductoServicio

    public String getProveedor(){
        //Todo: desarrollar la funcion getproveedor
        return "idProveedor";
    }

    // Constructor
    public ProductoServicio(Unidad unidad, float precioUnidad, TipoIva tipoIva, String idProductoServicio) {
        this.unidad = unidad;
        this.precioUnidad = precioUnidad;
        this.tipoIva = tipoIva;
        this.idProductoServicio = idProductoServicio;
    }
}
