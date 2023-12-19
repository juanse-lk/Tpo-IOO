package models;

import dto.RubroDTO;

import java.util.List;

public class Rubro {

    // Atributos
    private int idRubro;
    private String nombreRubro;
    private List<ProductoServicio> listaProductoServicio;


    // Metodos

    // Getters y Setters
    public List<ProductoServicio> getListaProductoServicio() {
        return listaProductoServicio;
    }

    public void setListaProductoServicio(List<ProductoServicio> listaProductoServicio) {
        this.listaProductoServicio = listaProductoServicio;
    }

    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }
// Constructor

    public Rubro(int idRubro) {
        this.idRubro = idRubro;
    }

    public Rubro(int idRubro, String nombreRubro, List<ProductoServicio> listaProductoServicio) {
        this.idRubro = idRubro;
        this.nombreRubro = nombreRubro;
        this.listaProductoServicio = listaProductoServicio;
    }

    public RubroDTO toDTO(){
        RubroDTO dto = new RubroDTO(
                this.getIdRubro(),
                this.getNombreRubro(),
                this.getListaProductoServicio());
        return dto;

    }

    public Rubro(RubroDTO rubroDto){
        this.idRubro = rubroDto.idRubro;
        this.nombreRubro = rubroDto.nombreRubro;
        this.listaProductoServicio = rubroDto.listaProductoServicio;
    }

    // Metodos de Rubro

    public List<ProductoServicio> getProductoServicioPorRubro() {
        return this.listaProductoServicio;
    }
}

