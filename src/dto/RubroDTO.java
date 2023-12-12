package dto;

import models.ProductoServicio;

import java.util.List;

public class RubroDTO {

    // Atributos
    private List<ProductoServicio> listaProductoServicio;
    private String idRubro;


    // Metodos

    // Getters y Setters
    public List<ProductoServicio> getListaProductoServicio() {
        return listaProductoServicio;
    }

    public void setListaProductoServicio(List<ProductoServicio> listaProductoServicio) {
        this.listaProductoServicio = listaProductoServicio;
    }

    public String getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(String idRubro) {
        this.idRubro = idRubro;
    }
}
