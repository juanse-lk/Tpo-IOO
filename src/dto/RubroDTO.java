package dto;

import models.ProductoServicio;
import models.Rubro;

import java.util.ArrayList;
import java.util.List;

public class RubroDTO {

    // Atributos
    private List<ProductoServicio> listaProductoServicio;
    private String idRubro;
    private  String nombreRubro;

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

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }


    // Constructors

    public RubroDTO(String idRubro, String nombreRubro, List<ProductoServicio> listaProductoServicio) {
        this.listaProductoServicio = listaProductoServicio;
        this.idRubro = idRubro;
        this.nombreRubro = nombreRubro;
    }

    public static Rubro toModel(RubroDTO dto){

        return new Rubro(
                dto.getIdRubro(),
                dto.getNombreRubro(),
                dto.getListaProductoServicio());
    }

    public static RubroDTO toDTO(Rubro r) {
        return new RubroDTO(
                r.getIdRubro(),
                r.getNombreRubro(),
                r.getListaProductoServicio());
    }

    // Metodos de RubroDTO
}
