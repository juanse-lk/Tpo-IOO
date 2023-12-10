package models;

import java.util.List;

public class Rubro {

    // Atributos

    private List<ProductoServicio> listaProductoServicio;
    private String idRubro;


    // Metodos

    // Getters
    public List<ProductoServicio> getListaProductoServicio() {
        return listaProductoServicio;
    }

    public void setListaProductoServicio(List<ProductoServicio> listaProductoServicio) {
        this.listaProductoServicio = listaProductoServicio;
    }

    public String getIdRubro() {
        return idRubro;
    }

    // Setters
    public void setIdRubro(String idRubro) {
        this.idRubro = idRubro;
    }

    // Constructor

    public Rubro(String idRubro) {
        this.idRubro = idRubro;
    }
}
